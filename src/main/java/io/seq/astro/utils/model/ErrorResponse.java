package io.seq.astro.utils.model;

import java.util.Date;

public class ErrorResponse {

    public String errorString;
    public String errorType;
    public Date timestamp;

    public ErrorResponse(String errorString, String errorType) {

        this.errorString = errorString;
        this.errorType = errorType;
        this.timestamp = new Date();
    }
}
