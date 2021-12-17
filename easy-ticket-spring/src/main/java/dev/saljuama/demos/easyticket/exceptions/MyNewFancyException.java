package dev.saljuama.demos.easyticket.exceptions;

public class MyNewFancyException extends RuntimeException {
    public MyNewFancyException() {
        super();
    }

    public MyNewFancyException(String message) {
        super(message);
    }
}
