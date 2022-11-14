package dev.jmoore.fcapi.api;

/**
 * @author Josh Moore <josh.moore@jmoore.dev> (https://tycrek.com)
 */
public class Endpoints {
    private static final String BASE_URL = "https://api.freecurrencyapi.com/v1";

    /**
     * @see <a href="https://freecurrencyapi.com/docs/status">/status</a>
     */
    public static final String STATUS = BASE_URL.concat("/status");

    /**
     * @see <a href="https://freecurrencyapi.com/docs/currencies">/currencies</a>
     */
    public static final String CURRENCIES = BASE_URL.concat("/currencies");

    /**
     * @see <a href="https://freecurrencyapi.com/docs/latest">/latest</a>
     */
    public static final String LATEST = BASE_URL.concat("/latest");

    /**
     * @see <a href="https://freecurrencyapi.com/docs/historical">/historical</a>
     */
    public static final String HISTORICAL = BASE_URL.concat("/historical");
}
