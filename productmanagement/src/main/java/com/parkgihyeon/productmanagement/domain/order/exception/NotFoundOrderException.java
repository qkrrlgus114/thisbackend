package com.parkgihyeon.productmanagement.domain.order.exception;

public class NotFoundOrderException extends RuntimeException{
    public NotFoundOrderException(String message) {
        super(message);
    }
}
