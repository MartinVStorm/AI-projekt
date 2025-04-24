package dk.kea.ai.util;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {
    @Value("${currency.api.key}")
    private static String apiKey;

    private static final String FIXER_URL = "http://data.fixer.io/api/latest?access_key=" + apiKey + "&symbols=USD,DKK";

    public static double getUSDtoDKKRate() {
        try {
            URL url = new URL(FIXER_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                JSONObject json = new JSONObject(response.toString());

                if (!json.optBoolean("success", false)) {
                    System.err.println("Currency API error: " + json.optJSONObject("error"));
                    return 6.8; // fallback
                }

                double usdRate = json.getJSONObject("rates").getDouble("USD");
                double dkkRate = json.getJSONObject("rates").getDouble("DKK");

                return dkkRate / usdRate;
            }
        } catch (Exception e) {
            System.err.println("Failed to fetch exchange rate: " + e.getMessage());
            return 6.8; // fallback
        }
    }
}
