package io.seq.astro.utils.exception.Exception;

import java.io.Serializable;

public class CommonHTTPException extends
        RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public CommonHTTPException() {
    }

    public CommonHTTPException(String message) {
        super(message);
    }

    public CommonHTTPException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonHTTPException(Throwable cause) {
        super(cause);
    }

    public CommonHTTPException(String message, Throwable cause,
                           boolean enableSuppression, boolean writableStackTrace) {

        super(message, cause, enableSuppression, writableStackTrace);
    }
}
