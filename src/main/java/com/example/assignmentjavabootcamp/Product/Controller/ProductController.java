package com.example.assignmentjavabootcamp.Product.Controller;

import com.example.assignmentjavabootcamp.Product.Model.Product;
import com.example.assignmentjavabootcamp.Product.Mapper.ProductMapper;
import com.example.assignmentjavabootcamp.Product.Model.ProductResponse;
import com.example.assignmentjavabootcamp.Product.Service.ProductService;
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
    public List<ProductResponse> searchProductsByName(@RequestParam(required = false) String productName){
        List<ProductResponse> responses = new ArrayList<>();

        List<Product> products;
        if(productName == null){
            products = productService.getAllProducts();
        }
        else {
            products = productService.getProductsByFilter(productName);
        }

        for (Product product:products) {
            ProductResponse result =productMapper.productToProductResponse(product);
            if(result != null)
            {
                responses.add(result);
            }
        }

        return responses;
    }

    @GetMapping("/{productId}")
    public ProductResponse getProductDetail(@PathVariable long productId){
        return  new ProductResponse();
    }
}
