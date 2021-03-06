package com.kuliashou.shape.exception;

public class TriangleException extends Exception {

    public TriangleException() {
        super();
    }

    public TriangleException(String message) {
        super(message);
    }

    public TriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleException(Throwable cause) {
        super(cause);
    }

    protected TriangleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
