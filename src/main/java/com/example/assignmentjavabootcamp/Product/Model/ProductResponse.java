package com.example.assignmentjavabootcamp.Product.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private int id;
    private String name;
    private String description;
    private int unitInStock;
    private double price;
    private boolean isPackage;
    private int categoryId;




}
