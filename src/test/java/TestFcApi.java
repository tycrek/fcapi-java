import dev.jmoore.fcapi.FcApi;
import dev.jmoore.fcapi.api.CurrencyList;
import dev.jmoore.fcapi.api.responses.CurrenciesResponse;
import dev.jmoore.fcapi.api.responses.StatusResponse;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class TestFcApi {
    static String API_KEY;

    static {
        try {
            API_KEY = Files.readString(Path.of("api_key.txt")).trim();
        } catch (IOException e) {
            System.err.printf("Failed to read API key from file: %s%n", e.getMessage());
            System.exit(1);
        }
    }
}
