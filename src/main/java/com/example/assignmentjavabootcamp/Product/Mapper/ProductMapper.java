package com.example.assignmentjavabootcamp.Product.Mapper;

import com.example.assignmentjavabootcamp.Product.Model.Product;
import com.example.assignmentjavabootcamp.Product.Model.ProductResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface  ProductMapper {

    ProductResponse productToProductResponse(Product product);
}
