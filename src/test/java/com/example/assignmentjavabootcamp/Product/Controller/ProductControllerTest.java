package com.example.assignmentjavabootcamp.Product.Controller;

import com.example.assignmentjavabootcamp.Product.Model.Product;
import com.example.assignmentjavabootcamp.Product.Model.ProductResponse;
import com.example.assignmentjavabootcamp.Product.Repository.ProductRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.h2.util.json.JSONString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ProductRepository productRepository;

    @Test
    @DisplayName("It should return chocolate product when search productName with chocolate")
    void searchProductsByName_SuccessCase() {

        //Arrange
        List<Product> mockProducts = new ArrayList();
        var mockProduct = new Product();
        mockProduct.setName("Chocolate100%");
        mockProducts.add(mockProduct);

        when(productRepository.getProductsByNameContainingIgnoreCase("chocolate")).thenReturn(Optional.of(mockProducts));

        //Act
       var response =  testRestTemplate
                .getForEntity("/api/v1/products?productName=chocolate", ProductResponse[].class);


        //Assert
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(false, response.getBody().length>1);
        assertEquals(true, response.getBody()[0].getName().toLowerCase().contains("chocolate"));
    }

    @Test
    @DisplayName("It should return not found message when search non exist productName with vanilla")
    void searchProductsByName_NotFoundCase() {

        //Arrange
        List<Product> mockProducts = new ArrayList();
        when(productRepository.getProductsByNameContainingIgnoreCase("vanilla")).thenReturn(Optional.of(mockProducts));

        //Act
        ResponseEntity<String> response =  testRestTemplate
                .getForEntity("/api/v1/products?productName=vanilla", String.class);

        //Assert
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
        assertEquals("vanilla not found",response.getBody());
    }

    @Test
    void getProductDetail() {
    }
}