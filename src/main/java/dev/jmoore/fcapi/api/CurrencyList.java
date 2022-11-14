package dev.jmoore.fcapi.api;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Josh Moore <josh.moore@jmoore.dev> (https://tycrek.com)
 * <p>
 * Available currencies from the <a href="https://freeCurrencyCodeapi.com/docs/CurrencyCode-list">CurrencyCode List</a>.
 */
public class CurrencyList {
    private static final List<CurrencyCode> currencies = new ArrayList<>();
    public static final CurrencyCode EUR = add("EUR", "Euro");
    public static final CurrencyCode USD = add("USD", "US Dollar");
    public static final CurrencyCode JPY = add("JPY", "Japanese Yen");
    public static final CurrencyCode BGN = add("BGN", "Bulgarian Lev");
    public static final CurrencyCode CZK = add("CZK", "Czech Republic Koruna");
    public static final CurrencyCode DKK = add("DKK", "Danish Krone");
    public static final CurrencyCode GBP = add("GBP", "British Pound Sterling");
    public static final CurrencyCode HUF = add("HUF", "Hungarian Forint");
    public static final CurrencyCode PLN = add("PLN", "Polish Zloty");
    public static final CurrencyCode RON = add("RON", "Romanian Leu");
    public static final CurrencyCode SEK = add("SEK", "Swedish Krona");
    public static final CurrencyCode CHF = add("CHF", "Swiss Franc");
    public static final CurrencyCode ISK = add("ISK", "Icelandic Króna");
    public static final CurrencyCode NOK = add("NOK", "Norwegian Krone");
    public static final CurrencyCode HRK = add("HRK", "Croatian Kuna");
    public static final CurrencyCode RUB = add("RUB", "Russian Ruble");
    public static final CurrencyCode TRY = add("TRY", "Turkish Lira");
    public static final CurrencyCode AUD = add("AUD", "Australian Dollar");
    public static final CurrencyCode BRL = add("BRL", "Brazilian Real");
    public static final CurrencyCode CAD = add("CAD", "Canadian Dollar");
    public static final CurrencyCode CNY = add("CNY", "Chinese Yuan");
    public static final CurrencyCode HKD = add("HKD", "Hong Kong Dollar");
    public static final CurrencyCode IDR = add("IDR", "Indonesian Rupiah");
    public static final CurrencyCode ILS = add("ILS", "Israeli New Sheqel");
    public static final CurrencyCode INR = add("INR", "Indian Rupee");
    public static final CurrencyCode KRW = add("KRW", "South Korean Won");
    public static final CurrencyCode MXN = add("MXN", "Mexican Peso");
    public static final CurrencyCode MYR = add("MYR", "Malaysian Ringgit");
    public static final CurrencyCode NZD = add("NZD", "New Zealand Dollar");
    public static final CurrencyCode PHP = add("PHP", "Philippine Peso");
    public static final CurrencyCode SGD = add("SGD", "Singapore Dollar");
    public static final CurrencyCode THB = add("THB", "Thai Baht");
    public static final CurrencyCode ZAR = add("ZAR", "South African Rand");

    private static CurrencyCode add(String code, String name) {
        CurrencyCode currencyCode = new CurrencyCode(code, name);
        currencies.add(currencyCode);
        return currencyCode;
    }

    @Nullable
    public static CurrencyCode getByCode(String code) {
        for (CurrencyCode currencyCode : currencies) {
            if (currencyCode.getCode().equalsIgnoreCase(code)) {
                return currencyCode;
            }
        }
        return null;
    }
}
