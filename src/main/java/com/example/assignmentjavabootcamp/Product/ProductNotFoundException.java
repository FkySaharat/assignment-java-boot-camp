package com.example.assignmentjavabootcamp.Product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String name) {
        super(name + " not found");
    }
}
