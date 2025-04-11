package dk.kea.ai.controller;

import dk.kea.ai.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SummarizeController {

    @Autowired
    private AiService aiService;

    @PostMapping("/summarize")
    public Map<String, String> summarize(@RequestBody Map<String, String> request) {
        String text = request.getOrDefault("text", "");
        String summary = aiService.summarizeText(text);
        return Map.of("summary", summary);
    }
}
