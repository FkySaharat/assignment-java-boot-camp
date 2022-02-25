package com.example.assignmentjavabootcamp.Product;

import com.example.assignmentjavabootcamp.Product.Product;
import com.example.assignmentjavabootcamp.Product.ProductMapper;
import com.example.assignmentjavabootcamp.Product.ProductResponse;
import com.example.assignmentjavabootcamp.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;
    
    @GetMapping
    public List<ProductResponse> getProductsByFilter(@RequestParam String productName){
        List<ProductResponse> responses = new ArrayList<>();
        List<Product> products = productService.getProductsByFilter(productName);
        for (Product product:products) {
            ProductResponse result =productMapper.productToProductResponse(product);
            if(result != null)
            {
                responses.add(result);
            }
        }
        return responses;
    }
}
