package dev.jmoore.fcapi.api.responses;

import lombok.Data;

/**
 * @author Josh Moore <josh.moore@jmoore.dev> (https://tycrek.com)
 *
 * Response implementation for <a href="https://freecurrencyapi.com/docs/currencies">/currencies</a>. *
 */
@Data
public class CurrenciesResponse {
    final Currencies data;

    @Data
    public static class Currencies {
        final Currency EUR;
        final Currency USD;
        final Currency JPY;
        final Currency BGN;
        final Currency CZK;
        final Currency DKK;
        final Currency GBP;
        final Currency HUF;
        final Currency PLN;
        final Currency RON;
        final Currency SEK;
        final Currency CHF;
        final Currency ISK;
        final Currency NOK;
        final Currency HRK;
        final Currency RUB;
        final Currency TRY;
        final Currency AUD;
        final Currency BRL;
        final Currency CAD;
        final Currency CNY;
        final Currency HKD;
        final Currency IDR;
        final Currency ILS;
        final Currency INR;
        final Currency KRW;
        final Currency MXN;
        final Currency MYR;
        final Currency NZD;
        final Currency PHP;
        final Currency SGD;
        final Currency THB;
        final Currency ZAR;
    }

    @Data
    public static class Currency {
        final String symbol;
        final String name;
        final String symbol_native;
        final int decimal_digits;
        final int rounding;
        final String code;
        final String name_plural;
    }
}
