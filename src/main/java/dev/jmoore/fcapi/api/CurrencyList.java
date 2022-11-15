package dev.jmoore.fcapi.api;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Josh Moore <josh.moore@jmoore.dev> (https://tycrek.com)
 * <p>
 * Available currencies from the <a href="https://freeCurrencyCodeapi.com/docs/CurrencyCode-list">CurrencyCode List</a>.
 */
@SuppressWarnings("unused")
public class CurrencyList {
    public static final CurrencyCode EUR = new CurrencyCode("EUR", "Euro");
    public static final CurrencyCode USD = new CurrencyCode("USD", "US Dollar");
    public static final CurrencyCode JPY = new CurrencyCode("JPY", "Japanese Yen");
    public static final CurrencyCode BGN = new CurrencyCode("BGN", "Bulgarian Lev");
    public static final CurrencyCode CZK = new CurrencyCode("CZK", "Czech Republic Koruna");
    public static final CurrencyCode DKK = new CurrencyCode("DKK", "Danish Krone");
    public static final CurrencyCode GBP = new CurrencyCode("GBP", "British Pound Sterling");
    public static final CurrencyCode HUF = new CurrencyCode("HUF", "Hungarian Forint");
    public static final CurrencyCode PLN = new CurrencyCode("PLN", "Polish Zloty");
    public static final CurrencyCode RON = new CurrencyCode("RON", "Romanian Leu");
    public static final CurrencyCode SEK = new CurrencyCode("SEK", "Swedish Krona");
    public static final CurrencyCode CHF = new CurrencyCode("CHF", "Swiss Franc");
    public static final CurrencyCode ISK = new CurrencyCode("ISK", "Icelandic Króna");
    public static final CurrencyCode NOK = new CurrencyCode("NOK", "Norwegian Krone");
    public static final CurrencyCode HRK = new CurrencyCode("HRK", "Croatian Kuna");
    public static final CurrencyCode RUB = new CurrencyCode("RUB", "Russian Ruble");
    public static final CurrencyCode TRY = new CurrencyCode("TRY", "Turkish Lira");
    public static final CurrencyCode AUD = new CurrencyCode("AUD", "Australian Dollar");
    public static final CurrencyCode BRL = new CurrencyCode("BRL", "Brazilian Real");
    public static final CurrencyCode CAD = new CurrencyCode("CAD", "Canadian Dollar");
    public static final CurrencyCode CNY = new CurrencyCode("CNY", "Chinese Yuan");
    public static final CurrencyCode HKD = new CurrencyCode("HKD", "Hong Kong Dollar");
    public static final CurrencyCode IDR = new CurrencyCode("IDR", "Indonesian Rupiah");
    public static final CurrencyCode ILS = new CurrencyCode("ILS", "Israeli New Sheqel");
    public static final CurrencyCode INR = new CurrencyCode("INR", "Indian Rupee");
    public static final CurrencyCode KRW = new CurrencyCode("KRW", "South Korean Won");
    public static final CurrencyCode MXN = new CurrencyCode("MXN", "Mexican Peso");
    public static final CurrencyCode MYR = new CurrencyCode("MYR", "Malaysian Ringgit");
    public static final CurrencyCode NZD = new CurrencyCode("NZD", "New Zealand Dollar");
    public static final CurrencyCode PHP = new CurrencyCode("PHP", "Philippine Peso");
    public static final CurrencyCode SGD = new CurrencyCode("SGD", "Singapore Dollar");
    public static final CurrencyCode THB = new CurrencyCode("THB", "Thai Baht");
    public static final CurrencyCode ZAR = new CurrencyCode("ZAR", "South African Rand");
    private static final Map<String, CurrencyCode> CURRENCY_MAP = new HashMap<>();

    static {
        // Quickly populate the map using reflection
        for (Field field : CurrencyList.class.getFields())
            try {
                var currencyCode = (CurrencyCode) field.get(null);
                CURRENCY_MAP.put(currencyCode.getCode(), currencyCode);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (ClassCastException e) {
                // Ignore (not a CurrencyCode)
            }
    }

    /**
     * Gets a {@link CurrencyCode} from a String. Useful for converting user input to a {@link CurrencyCode}.
     *
     * @throws InvalidCurrencyException if the currency code is invalid.
     */
    public static CurrencyCode getCode(String code) throws InvalidCurrencyException {
        if (!CURRENCY_MAP.containsKey(code))
            throw new InvalidCurrencyException(String.format("Currency code '%s' is not valid.", code));
        return CURRENCY_MAP.get(code);
    }
}
