package com.product.service.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductException extends RuntimeException {

    private String message;

    public ProductException(String message) {
        super(message);
    }
}
