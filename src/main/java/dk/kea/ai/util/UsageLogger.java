package dk.kea.ai.util;

import dk.kea.ai.dto.ApiUsageDTO;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class UsageLogger {

    private static final String FILE_PATH = "api-usage.log";

    public static void log(ApiUsageDTO usage) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String line = String.format("[%s] Tokens used: %d, Total calls: %d, Response time: %d ms, Estimated cost: $%.6f (%.6f DKK)\n",
                    LocalDateTime.now(), usage.getTokensUsed(), usage.getTotalCalls(),
                    usage.getTotalResponseTime(), usage.getEstimatedCost(), usage.getEstimatedCostDKK());
            writer.write(line);
        } catch (IOException e) {
            System.err.println("Failed to log API usage: " + e.getMessage());
        }
    }
}
