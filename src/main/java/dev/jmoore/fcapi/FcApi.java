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
}
