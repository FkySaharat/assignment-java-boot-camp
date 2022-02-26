package com.example.assignmentjavabootcamp.Product.Exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String name) {
        super(name + " not found");
    }
}
