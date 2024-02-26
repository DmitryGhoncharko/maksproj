package com.example.mobilebackendmaks.exception;

public class DaoError extends Error{
    public DaoError() {
    }

    public DaoError(String message) {
        super(message);
    }

    public DaoError(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoError(Throwable cause) {
        super(cause);
    }

    public DaoError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
