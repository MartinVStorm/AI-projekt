package dk.kea.ai.service;

import dk.kea.ai.dto.ApiUsageDTO;
import dk.kea.ai.dto.SummaryResponseDTO;
import dk.kea.ai.util.CurrencyConverter;
import dk.kea.ai.util.UsageLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class AiService {

    private final WebClient client = WebClient.create();
    @Value("${openai.api.key}")
    private String apiKey;
    @Value("${openai.api.url}")
    private String apiUrl;

    public SummaryResponseDTO summarizeText(String inputText) {
        String prompt = "Summarize this text as much as possible without leaving out information. Answer in the same language as the text is written in:\n\n" + inputText;

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(
                        Map.of("role", "user", "content", prompt)
                )
        );

        long start = System.currentTimeMillis();
        Map<String, Object> response = client.post()
                .uri(apiUrl)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        long end = System.currentTimeMillis();

        Map<String, Object> usage = (Map<String, Object>) response.get("usage");
        int tokensUsed = usage != null && usage.containsKey("total_tokens") ? (int) usage.get("total_tokens") : 0;

        double estimatedCostUSD = tokensUsed * 0.002 / 1000;
        double exchangeRate = CurrencyConverter.getUSDtoDKKRate();
        double estimatedCostDKK = estimatedCostUSD * exchangeRate;

        ApiUsageDTO usageDTO = new ApiUsageDTO(tokensUsed, 1, end - start, estimatedCostUSD, estimatedCostDKK);
        UsageLogger.log(usageDTO);

        var choices = (List<Map<String, Object>>) response.get("choices");
        var message = (Map<String, Object>) choices.get(0).get("message");
        String summary = (String) message.get("content");

        return new SummaryResponseDTO(summary, usageDTO);
    }

}
