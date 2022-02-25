package com.example.assignmentjavabootcamp.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByFilter(String name){
        Optional<List<Product>> result = productRepository.getProductsByName(name);
        if(result.isPresent() && !result.get().isEmpty()){
            return result.get();
        }
        throw  new  ProductNotFoundException(name);
    }
}
