package com.parkgihyeon.productmanagement.domain.product.exception;

public class NotFoundProductException extends RuntimeException{
    public NotFoundProductException(String message) {
        super(message);
    }
}
