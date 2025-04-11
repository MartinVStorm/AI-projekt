//package dk.kea.ai.entity;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//public class ApiUsage {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private LocalDateTime timestamp;
//    private String prompt;
//    private int promptTokens;
//    private int completionTokens;
//    private int totalTokens;
//    private double estimatedCost;
//
//    public ApiUsage() {}
//
//    public ApiUsage(String prompt, int promptTokens, int completionTokens, double estimatedCost) {
//        this.timestamp = LocalDateTime.now();
//        this.prompt = prompt;
//        this.promptTokens = promptTokens;
//        this.completionTokens = completionTokens;
//        this.totalTokens = promptTokens + completionTokens;
//        this.estimatedCost = estimatedCost;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public LocalDateTime getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(LocalDateTime timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public String getPrompt() {
//        return prompt;
//    }
//
//    public void setPrompt(String prompt) {
//        this.prompt = prompt;
//    }
//
//    public int getPromptTokens() {
//        return promptTokens;
//    }
//
//    public void setPromptTokens(int promptTokens) {
//        this.promptTokens = promptTokens;
//    }
//
//    public int getCompletionTokens() {
//        return completionTokens;
//    }
//
//    public void setCompletionTokens(int completionTokens) {
//        this.completionTokens = completionTokens;
//    }
//
//    public int getTotalTokens() {
//        return totalTokens;
//    }
//
//    public void setTotalTokens(int totalTokens) {
//        this.totalTokens = totalTokens;
//    }
//}