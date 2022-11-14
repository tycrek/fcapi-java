package dev.jmoore.fcapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.jmoore.fcapi.api.CurrencyCode;
import dev.jmoore.fcapi.api.Endpoints;
import dev.jmoore.fcapi.api.responses.CurrenciesResponse;
import dev.jmoore.fcapi.api.responses.StatusResponse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

// todo: cache latest, allow user to set cache time

/**
 * @author Josh Moore <josh.moore@jmoore.dev> (https://tycrek.com)
 * <p>
 * API wrapper for <a href="https://freecurrencyapi.com">FreeCurrencyAPI</a>.
 */
public class FcApi {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final AtomicReference<String> token = new AtomicReference<>();

    public FcApi(String token) {
        this.token.set(token);
    }

    /**
     * @see <a href="https://freecurrencyapi.com/docs/status">/status</a>
     */
    public StatusResponse getStatus() throws IOException {
        return GSON.fromJson(Http.GET(token.get(), Endpoints.STATUS), StatusResponse.class);
    }

    /**
     * @see <a href="https://freecurrencyapi.com/docs/currencies">/currencies</a>
     */
    public CurrenciesResponse getCurrencies() throws IOException {
        return getCurrencies(new CurrencyCode[0]);
    }

    /**
     * @see <a href="https://freecurrencyapi.com/docs/currencies">/currencies</a>
     * @param currencies Optional currencies to filter by. Note that ALL currencies will be returned, though if not specified, will return `null` when accessed.
     */
    public CurrenciesResponse getCurrencies(CurrencyCode... currencies) throws IOException {
        var endpoint = Endpoints.CURRENCIES;
        if (currencies.length > 0) {
            endpoint = endpoint.concat("?currencies=");

            for (var currency : currencies)
                endpoint = endpoint.concat(currency.getCode()).concat(",");

            // Remove trailing comma
            endpoint = endpoint.substring(0, endpoint.length() - 1);
        }

        return GSON.fromJson(Http.GET(token.get(), endpoint), CurrenciesResponse.class);
    }
}
