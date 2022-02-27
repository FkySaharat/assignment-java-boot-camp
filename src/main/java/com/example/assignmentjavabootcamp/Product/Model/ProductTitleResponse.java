package com.example.assignmentjavabootcamp.Product.Model;

import lombok.Data;

@Data
public class ProductTitleResponse {

    private long id;
    private String productName;
    private double price;
    private double discount;
    private int unitInStock;
    private String storeLocation;
    private String imageUrl;

}
