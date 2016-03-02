package com.epam.task3.exception;

/**
 * Created by Никита on 20.12.2015.
 */
public class EmptyTextException extends Exception{
    public EmptyTextException() {
    }

    public EmptyTextException(String message) {
        super(message);
    }

    public EmptyTextException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyTextException(Throwable cause) {
        super(cause);
    }

    public EmptyTextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
