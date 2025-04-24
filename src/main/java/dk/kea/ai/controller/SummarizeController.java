package dk.kea.ai.controller;

import dk.kea.ai.dto.SummaryResponseDTO;
import dk.kea.ai.service.AiService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SummarizeController {

    private final AiService aiService;

    public SummarizeController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/summarize")
    public SummaryResponseDTO summarize(@RequestBody Map<String, String> request) {
        String text = request.getOrDefault("text", "");
        return aiService.summarizeText(text);
    }

}
