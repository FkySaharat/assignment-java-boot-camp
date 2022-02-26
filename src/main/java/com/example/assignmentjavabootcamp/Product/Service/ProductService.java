package com.example.assignmentjavabootcamp.Product.Service;

import com.example.assignmentjavabootcamp.Product.Model.Product;
import com.example.assignmentjavabootcamp.Product.Exception.ProductNotFoundException;
import com.example.assignmentjavabootcamp.Product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        Optional<List<Product>> result = productRepository.getAllProducts();
        if(result.isPresent() && !result.get().isEmpty()){
            return result.get();
        }
        throw  new ProductNotFoundException("products");
    }

    public List<Product> getProductsByFilter(String name){
        Optional<List<Product>> result = productRepository.getProductsByNameContainingIgnoreCase(name);
        if(result.isPresent() && !result.get().isEmpty()){
            return result.get();
        }
        throw  new  ProductNotFoundException(name);
    }
}
