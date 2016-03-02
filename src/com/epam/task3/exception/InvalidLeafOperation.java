package com.epam.task3.exception;

/**
 * Created by Никита on 20.12.2015.
 */
public class InvalidLeafOperation extends Exception {
    public InvalidLeafOperation() {
    }

    public InvalidLeafOperation(String message) {
        super(message);
    }

    public InvalidLeafOperation(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLeafOperation(Throwable cause) {
        super(cause);
    }

    public InvalidLeafOperation(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
