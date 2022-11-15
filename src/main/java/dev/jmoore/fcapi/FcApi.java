package dev.jmoore.fcapi;

import dev.jmoore.fcapi.api.Wrapper;
import lombok.Getter;

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
}
