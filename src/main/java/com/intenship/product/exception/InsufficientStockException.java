package com.intenship.product.exception;

import lombok.Data;

@Data
public class InsufficientStockException extends Exception{
    private String message;
    public InsufficientStockException(String message) {
        this.message=message;
    }
}
