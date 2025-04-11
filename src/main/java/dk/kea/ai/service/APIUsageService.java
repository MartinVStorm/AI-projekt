//package dk.kea.ai.service;
//
//import dk.kea.ai.entity.ApiUsage;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class APIUsageService {
//
//    private static final double COST_PER_1K_TOKENS = 0.0015;
//
//    private final List<ApiUsage> usageHistory = new ArrayList<>();
//
//    public SummarizeResponseDTO createResponseDTO(OpenAiResponse response, String prompt) {
//        int totalTokens = response.getPromptTokens() + response.getCompletionTokens();
//        double estimatedCost = totalTokens / 1000.0 * COST_PER_1K_TOKENS;
//
//        ApiUsage usage = new ApiUsage(
//                prompt,
//                response.getPromptTokens(),
//                response.getCompletionTokens(),
//                estimatedCost
//        );
//        usageHistory.add(usage);
//
//        return new SummarizeResponseDTO(
//                response.getSummary(),
//                response.getPromptTokens(),
//                response.getCompletionTokens(),
//                estimatedCost
//        );
//    }
//
//    public List<ApiUsage> getUsageHistory() {
//        return Collections.unmodifiableList(usageHistory);
//    }
//}
