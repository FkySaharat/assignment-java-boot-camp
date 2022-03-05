package com.example.assignmentjavabootcamp.Product.Model;

import javax.persistence.*;

@Entity
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false,nullable = false)
    private Integer id;

    private Integer imageOrder;

    @Column(nullable = false)
    private String imageUrl;

    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name="productId", nullable = false)
    private Product product;



}

