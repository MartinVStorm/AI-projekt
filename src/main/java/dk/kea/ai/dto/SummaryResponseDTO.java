package dk.kea.ai.dto;

public class SummaryResponseDTO {
    private String summary;
    private ApiUsageDTO usage;

    public SummaryResponseDTO() {
    }

    public SummaryResponseDTO(String summary, ApiUsageDTO usage) {
        this.summary = summary;
        this.usage = usage;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ApiUsageDTO getUsage() {
        return usage;
    }

    public void setUsage(ApiUsageDTO usage) {
        this.usage = usage;
    }
}
