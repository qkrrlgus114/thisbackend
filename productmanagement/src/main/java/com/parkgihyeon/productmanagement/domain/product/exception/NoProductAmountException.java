package com.parkgihyeon.productmanagement.domain.product.exception;

public class NoProductAmountException extends RuntimeException{
    public NoProductAmountException(String message) {
        super(message);
    }
}
