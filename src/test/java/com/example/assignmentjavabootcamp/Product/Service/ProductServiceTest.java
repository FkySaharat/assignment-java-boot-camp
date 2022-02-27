package com.example.assignmentjavabootcamp.Product.Service;

import com.example.assignmentjavabootcamp.Product.Model.Product;
import com.example.assignmentjavabootcamp.Product.Model.ProductResponse;
import com.example.assignmentjavabootcamp.Product.Repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("It should return chocolate product when search product with chocolate")
    void getProductsByFilter_SuccessCase() {
        //Arrange
        List<Product> mockProducts = new ArrayList();
        var mockProduct = new Product();
        mockProduct.setName("Chocolate100%");
        mockProducts.add(mockProduct);

        when(productRepository.getProductsByNameContainingIgnoreCase("chocolate")).thenReturn(Optional.of(mockProducts));

        //Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<Product> result = productService.getProductsByFilter("chocolate");

        //Assert
        assertEquals(false, result.isEmpty());
    }
}