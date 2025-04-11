package dk.kea.ai.controller;

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
    public Map<String, String> summarize(@RequestBody Map<String, String> request) {
        String text = request.getOrDefault("text", "");
        String summary = aiService.summarizeText(text);
        return Map.of("summary", summary);
    }
}
