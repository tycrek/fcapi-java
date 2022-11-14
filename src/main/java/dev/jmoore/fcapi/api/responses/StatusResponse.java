package dev.jmoore.fcapi.api.responses;

import lombok.Data;

/**
 * @author Josh Moore <josh.moore@jmoore.dev> (https://tycrek.com)
 * <p>
 * Response implementation for <a href="https://freecurrencyapi.com/docs/status">/currencies</a>.
 */
@Data
public class StatusResponse {
    final Quotas quotas;

    @Data
    public static class Quotas {
        final Month month;
        final Grace grace;

        @Data
        public static class Month {
            final int total;
            final int used;
            final int remaining;
        }

        @Data
        public static class Grace {
            final int total;
            final int used;
            final int remaining;
        }
    }
}
