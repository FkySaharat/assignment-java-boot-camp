package com.example.assignmentjavabootcamp.Product.Repository;

import com.example.assignmentjavabootcamp.Product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends  JpaRepository<Product,Integer>{

    @Query(value = "select p from Product p")
    Optional<List<Product>> getAllProducts();

    Optional<List<Product>> getProductsByNameContainingIgnoreCase(String name);
}
