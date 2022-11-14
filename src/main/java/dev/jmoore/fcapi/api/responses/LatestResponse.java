package dev.jmoore.fcapi.api.responses;

import lombok.Data;

/**
 * @author Josh Moore <josh.moore@jmoore.dev> (https://tycrek.com)
 *
 * Response implementation for <a href="https://freecurrencyapi.com/docs/latest">/latest</a>. *
 */
@Data
public class LatestResponse {
    final Rates data;

    @Data
    public static class Rates {
        final double EUR;
        final double USD;
        final double JPY;
        final double BGN;
        final double CZK;
        final double DKK;
        final double GBP;
        final double HUF;
        final double PLN;
        final double RON;
        final double SEK;
        final double CHF;
        final double ISK;
        final double NOK;
        final double HRK;
        final double RUB;
        final double TRY;
        final double AUD;
        final double BRL;
        final double CAD;
        final double CNY;
        final double HKD;
        final double IDR;
        final double ILS;
        final double INR;
        final double KRW;
        final double MXN;
        final double MYR;
        final double NZD;
        final double PHP;
        final double SGD;
        final double THB;
        final double ZAR;
    }
}
