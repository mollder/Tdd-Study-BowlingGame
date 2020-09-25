package org.ingue.bowling;

public class NotHaveChanceException extends RuntimeException {

    public NotHaveChanceException() {
        super();
    }

    public NotHaveChanceException(String msg) {
        super(msg);
    }
}
