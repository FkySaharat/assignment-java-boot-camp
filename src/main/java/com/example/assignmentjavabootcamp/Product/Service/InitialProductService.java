package com.example.assignmentjavabootcamp.Product.Service;

import com.example.assignmentjavabootcamp.Product.Model.Product;
import com.example.assignmentjavabootcamp.Product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitialProductService {

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    private ProductRepository productRepository;



    public void  initialData(){
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product();
        product1.setName("Low Fat Milk Meiji");
        product1.setDescription("Low Fat Milk 250ML.");
        product1.setAmount(12);
        product1.setPrice(12);
        product1.setCategoryId(0);
        product1.setPackage(false);
        productList.add(product1);

        Product product2 = new Product();
        product2.setName("NamTip");
        product2.setDescription("water");
        product2.setAmount(12);
        product2.setPrice(18);
        product2.setCategoryId(0);
        product2.setPackage(false);
        productList.add(product2);

        Product product3 = new Product();
        product3.setName("EpsonABC Series Printer");
        product3.setDescription("Laser printer");
        product3.setAmount(12);
        product3.setPrice(12);
        product3.setCategoryId(0);
        product3.setPackage(false);
        productList.add(product3);

        Product product4 = new Product();
        product4.setName("Almond m&m milk chocolate bar");
        product4.setDescription("almond and milk chocolate bar");
        product4.setAmount(6);
        product4.setPrice(35);
        product4.setCategoryId(0);
        product4.setPackage(false);
        productList.add(product4);

        productRepository.saveAll(productList);
    }
}
