package com.product.service.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileNameException extends RuntimeException {

    private String message;

    public FileNameException(String message) {
        super(message);
    }
}
