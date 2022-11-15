package dev.jmoore.fcapi.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.jmoore.fcapi.api.responses.CurrenciesResponse;
import dev.jmoore.fcapi.api.responses.LatestResponse;
import dev.jmoore.fcapi.api.responses.StatusResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

/**
 * @author Josh Moore <josh.moore@jmoore.dev> (https://tycrek.com)
 * <p>
 * API wrapper for <a href="https://freecurrencyapi.com">FreeCurrencyAPI</a>.
 */
@RequiredArgsConstructor
public class Wrapper {
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final String token;

    /**
     * @see <a href="https://freecurrencyapi.com/docs/status">/status</a>
     */
    public StatusResponse getStatus() throws IOException {
        return this.GSON.fromJson(Http.GET(token, Endpoints.STATUS), StatusResponse.class);
    }

    /**
     * @param currencies Optional currencies to filter by. Note that ALL currencies will be returned, though if not specified, will return `null` when accessed.
     * @see <a href="https://freecurrencyapi.com/docs/currencies">/currencies</a>
     */
    public CurrenciesResponse getCurrencies(CurrencyCode... currencies) throws IOException {
        return this.GSON.fromJson(Http.GET(token, buildCurrenciesParam(Endpoints.CURRENCIES, currencies)), CurrenciesResponse.class);
    }

    /**
     * @see <a href="https://freecurrencyapi.com/docs/latest">/latest</a>
     */
    public LatestResponse getLatest() throws IOException {
        return getLatest(CurrencyList.USD);
    }

    /**
     * @param baseCurrency The base currency to convert from.
     * @param currencies   Optional currencies to filter by. Note that ALL currencies will be returned, though if not specified, will return `null` when accessed.
     * @see <a href="https://freecurrencyapi.com/docs/latest">/latest</a>
     */
    public LatestResponse getLatest(CurrencyCode baseCurrency, CurrencyCode... currencies) throws IOException {
        var endpoint = Endpoints.LATEST.concat("?base_currency=").concat(baseCurrency.getCode());
        return this.GSON.fromJson(Http.GET(token, buildCurrenciesParam(endpoint, currencies)), LatestResponse.class);
    }

    private String buildCurrenciesParam(String endpoint, CurrencyCode[] currencies) {
        if (currencies.length > 0) {
            endpoint = endpoint.concat(endpoint.contains("?") ? "&" : "?").concat("currencies=");

            for (var currency : currencies)
                endpoint = endpoint.concat(currency.getCode()).concat(",");

            // Remove trailing comma
            endpoint = endpoint.substring(0, endpoint.length() - 1);
        }

        return endpoint;
    }
}
