package io.seq.astro.utils.exception;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ErrorMessage {

    private String error;
    private String errorDescription;
    private String errorType;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public ErrorMessage(String error, String errorDescription, String errorType) {
        this.error = error;
        this.errorDescription = errorDescription;
        this.errorType = errorType;
    }
}
