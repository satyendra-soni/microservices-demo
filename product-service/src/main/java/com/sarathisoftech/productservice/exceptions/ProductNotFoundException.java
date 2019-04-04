package com.sarathisoftech.productservice.exceptions;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String s) {
        super(s );
    }
}
