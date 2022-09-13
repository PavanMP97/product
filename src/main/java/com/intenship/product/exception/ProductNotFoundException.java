package com.intenship.product.exception;

import lombok.Data;

@Data
public class ProductNotFoundException extends Exception {
    private String message;
    public ProductNotFoundException(String message) {
        this.message=message;
    }
}
