package com.example.assignmentjavabootcamp.Product.Model;

import org.mapstruct.TargetType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private int unitInStock;

    private double price;

    private boolean isPackage;

    private int categoryId;

    private int storeId;

    private String storeAddress;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> images = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public void setAmount(int amount) {
        this.unitInStock = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPackage() {
        return isPackage;
    }

    public void setPackage(boolean aPackage) {
        isPackage = aPackage;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }


    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }
}
