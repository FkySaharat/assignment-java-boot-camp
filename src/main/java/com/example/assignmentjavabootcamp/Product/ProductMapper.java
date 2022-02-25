package com.example.assignmentjavabootcamp.Product;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface  ProductMapper {

    ProductResponse productToProductResponse(Product product);
}
