import dev.jmoore.fcapi.FcApi;
import dev.jmoore.fcapi.api.CurrencyList;
import dev.jmoore.fcapi.api.InvalidCurrencyException;
import dev.jmoore.fcapi.api.responses.CurrenciesResponse;
import dev.jmoore.fcapi.api.responses.LatestResponse;
import dev.jmoore.fcapi.api.responses.StatusResponse;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

// todo: properly implement junit assertions
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

    @Test
    @SneakyThrows
    public void testCurrencyListGetCodeSuccessful() {
        System.out.println(CurrencyList.getCode("USD").toString());
    }

    @Test
    public void testCurrencyListGetCodeFailure() {
        try {
            CurrencyList.getCode("USDD");
        } catch (InvalidCurrencyException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }

    @Test
    public void testStatus() {
        FcApi api = new FcApi(API_KEY);

        try {
            StatusResponse status = api.getWrapper().getStatus();
            System.out.println(status);
            System.out.printf("Remaining requests: %d%n", status.getQuotas().getMonth().getRemaining());
            System.out.printf("Total requests: %d%n", status.getQuotas().getMonth().getTotal());
            System.out.printf("Used requests: %d%n", status.getQuotas().getMonth().getUsed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCurrencies() {
        FcApi api = new FcApi(API_KEY);

        try {
            CurrenciesResponse currencies = api.getWrapper().getCurrencies();
            System.out.println(currencies);
            System.out.printf("JPY: %s%n", currencies.getData().getJPY().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSpecificCurrencies() {
        FcApi api = new FcApi(API_KEY);

        try {
            CurrenciesResponse currencies = api.getWrapper().getCurrencies(CurrencyList.AUD, CurrencyList.CAD, CurrencyList.EUR, CurrencyList.USD);
            System.out.println(currencies);
            System.out.printf("AUD: %s%n", currencies.getData().getAUD().getName());
            System.out.printf("CAD: %s%n", currencies.getData().getCAD().getName());
            System.out.printf("EUR: %s%n", currencies.getData().getEUR().getName());
            System.out.printf("USD: %s%n", currencies.getData().getUSD().getName());
            System.out.printf("JPY: %s%n", currencies.getData().getJPY().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLatest() {
        FcApi api = new FcApi(API_KEY);

        try {
            LatestResponse latest = api.getWrapper().getLatest();
            System.out.println(latest);
            System.out.printf("EUR: %f%n", latest.getData().getEUR());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLatestDifferentBases() {
        FcApi api = new FcApi(API_KEY);

        try {
            LatestResponse latestDefault = api.getWrapper().getLatest();
            LatestResponse latestCadDef = api.getWrapper().getLatest(CurrencyList.CAD);
            System.out.println(latestDefault);
            System.out.println(latestCadDef);
            System.out.printf("EUR/USD: %f%n", latestDefault.getData().getEUR());
            System.out.printf("EUR/CAD: %f%n", latestCadDef.getData().getEUR());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConvert() {
        FcApi api = new FcApi(API_KEY);

        try {
            System.out.println(api.convert("CAD", "USD", 69.0D));
            System.out.println(api.convert("CAD", "USD", 42.0f));
            System.out.println(api.convert("CAD", "USD", new BigDecimal("100")));
        } catch (IOException | InvalidCurrencyException e) {
            e.printStackTrace();
        }
    }
}
