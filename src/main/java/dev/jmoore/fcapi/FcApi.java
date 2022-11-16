package dev.jmoore.fcapi;

import dev.jmoore.fcapi.api.CurrencyCode;
import dev.jmoore.fcapi.api.CurrencyList;
import dev.jmoore.fcapi.api.InvalidCurrencyException;
import dev.jmoore.fcapi.api.Wrapper;
import dev.jmoore.fcapi.api.responses.LatestResponse;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.IOException;
import java.math.BigDecimal;

// todo: cache latest, allow user to set cache time

/**
 * @author Josh Moore <josh.moore@jmoore.dev> (https://tycrek.com)
 * <p>
 * Utility & helper functions for currency conversion. For direct API access, see {@link Wrapper}.
 */
public class FcApi {
    @Getter private final Wrapper wrapper;

    public FcApi(String token) {
        this.wrapper = new Wrapper(token);
    }

    /**
     * Converts an amount of currency to another currency.
     */
    public BigDecimal convert(String from, String to, float amount) throws IOException, InvalidCurrencyException {
        return convert(CurrencyList.getCode(from), CurrencyList.getCode(to), floatToBigDecimal(amount));
    }

    /**
     * Converts an amount of currency to another currency.
     */
    public BigDecimal convert(String from, String to, double amount) throws IOException, InvalidCurrencyException {
        return convert(CurrencyList.getCode(from), CurrencyList.getCode(to), doubleToBigDecimal(amount));
    }

    /**
     * Converts an amount of currency to another currency.
     */
    public BigDecimal convert(String from, String to, BigDecimal amount) throws IOException, InvalidCurrencyException {
        return convert(CurrencyList.getCode(from), CurrencyList.getCode(to), amount);
    }

    /**
     * Converts an amount of currency to another currency.
     */
    public BigDecimal convert(CurrencyCode from, CurrencyCode to, BigDecimal amount) throws IOException {
        var rate = getRateWithReflection(wrapper.getLatest(from, from, to).getData(), to);
        return doubleToBigDecimal(rate).multiply(amount);
    }

    @SneakyThrows
    private double getRateWithReflection(LatestResponse.Rates rates, CurrencyCode to) {
        // Don't worry about it
        var method = String.format("get%s", to.getCode());
        return (double) rates.getClass().getMethod(method).invoke(rates);
    }

    /**
     * Converts a double to a BigDecimal. Uses {@link Double#toString(double)} to ensure precision during conversion.
     */
    private BigDecimal doubleToBigDecimal(double d) {
        return new BigDecimal(Double.toString(d));
    }

    /**
     * Converts a float to a BigDecimal. Uses {@link Float#toString(float)} to ensure precision during conversion.
     */
    private BigDecimal floatToBigDecimal(float f) {
        return new BigDecimal(Float.toString(f));
    }
}
