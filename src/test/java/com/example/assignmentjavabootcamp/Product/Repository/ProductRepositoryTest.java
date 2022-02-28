package com.example.assignmentjavabootcamp.Product.Repository;

import com.example.assignmentjavabootcamp.Product.Model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void getAllProducts_SuccessCase() {
        //Arrange
        int numOfProduct = 0;
        Optional<List<Product>> defaultProduct = productRepository.getAllProducts();
        if(defaultProduct.isPresent()){
            numOfProduct = defaultProduct.get().size();
        }
        List<Product> mockProduct = new ArrayList();
        Product product1 = new Product();
        product1.setName("product1");
        mockProduct.add(product1);

        Product product2 = new Product();
        product2.setName("product2");
        mockProduct.add(product2);

        productRepository.saveAll(mockProduct);

        //Act
        Optional<List<Product>> result = productRepository.getAllProducts();

        //Assert
        assertTrue(result.isPresent());
        assertEquals(numOfProduct+2,result.get().size());
    }

    @Test
    void getProductsByNameContainingIgnoreCase() {
        //Arrange
        List<Product> mockProduct = new ArrayList();
        Product product1 = new Product();
        product1.setName("product1");
        mockProduct.add(product1);

        Product product2 = new Product();
        product2.setName("product2");
        mockProduct.add(product2);

        productRepository.saveAll(mockProduct);

        //Act
        Optional<List<Product>> result = productRepository.getProductsByNameContainingIgnoreCase("1");

        //Assert
        assertTrue(result.isPresent());
        assertEquals(1,result.get().size());
    }
}