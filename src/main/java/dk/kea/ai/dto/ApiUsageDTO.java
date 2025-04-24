package dk.kea.ai.dto;

public class ApiUsageDTO {
    private int tokensUsed;
    private int totalCalls;
    private long totalResponseTime;
    private double estimatedCost;
    private double estimatedCostDKK;

    public ApiUsageDTO(int tokensUsed, int totalCalls, long totalResponseTime, double estimatedCost, double estimatedCostDKK) {
        this.tokensUsed = tokensUsed;
        this.totalCalls = totalCalls;
        this.totalResponseTime = totalResponseTime;
        this.estimatedCost = estimatedCost;
        this.estimatedCostDKK = estimatedCostDKK;
    }

    public int getTokensUsed() {
        return tokensUsed;
    }

    public void setTokensUsed(int tokensUsed) {
        this.tokensUsed = tokensUsed;
    }

    public int getTotalCalls() {
        return totalCalls;
    }

    public void setTotalCalls(int totalCalls) {
        this.totalCalls = totalCalls;
    }

    public long getTotalResponseTime() {
        return totalResponseTime;
    }

    public void setTotalResponseTime(long totalResponseTime) {
        this.totalResponseTime = totalResponseTime;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public double getEstimatedCostDKK() {
        return estimatedCostDKK;
    }

    public void setEstimatedCostDKK(double estimatedCostDKK) {
        this.estimatedCostDKK = estimatedCostDKK;
    }
}
