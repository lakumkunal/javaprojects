import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static Map<String, Double> exchangeRates;

    static {
        // Initialize exchange rates with some default values.
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
        exchangeRates.put("JPY", 110.25);
        exchangeRates.put("INR", 74.94);
    }

    // Method to fetch the latest exchange rates from an external API (hypothetical
    // example).
    private static void updateExchangeRatesFromAPI() {
        // Code to fetch the latest exchange rates from an external API and update the
        // exchangeRates map.
        // For demonstration purposes, let's assume we are updating the rates for USD
        // and EUR.
        exchangeRates.put("USD", 1.12); // 1 USD = 1.12 EUR
        exchangeRates.put("EUR", 0.89); // 1 EUR = 0.89 USD
    }

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);
        return (amount / fromRate) * toRate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");
        System.out.println("Available currencies: USD, EUR, GBP, JPY, INR");

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the source currency (e.g., USD): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (e.g., EUR): ");
        String toCurrency = scanner.next().toUpperCase();

        // Fetch the latest exchange rates before performing the conversion.
        updateExchangeRatesFromAPI();

        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);

        // Format the output to two decimal places.
        DecimalFormat df = new DecimalFormat("#.##");

        System.out
                .println(amount + " " + fromCurrency + " is equal to " + df.format(convertedAmount) + " " + toCurrency);

        scanner.close();
    }
}
