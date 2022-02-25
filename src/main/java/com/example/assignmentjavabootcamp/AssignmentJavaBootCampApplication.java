package com.example.assignmentjavabootcamp;

import com.example.assignmentjavabootcamp.Product.Product;
import com.example.assignmentjavabootcamp.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class AssignmentJavaBootCampApplication {

	@Autowired
	private ProductRepository productRepository;

	@PostConstruct
	public  void initialData(){
		List<Product> productList = new ArrayList<>();

		Product product1 = new Product();
		product1.setName("Low Fat Milk Meiji");
		product1.setDescription("Low Fat Milk 250ML.");
		product1.setAmount(12);
		product1.setPrice(12);
		product1.setCategoryId(0);
		product1.setPackage(false);
		productList.add(product1);

//		Product product2 = new Product();
//		product1.setName("NamTip");
//		product1.setDescription("water");
//		product1.setAmount(12);
//		product1.setPrice(18);
//		product1.setCategoryId(0);
//		product1.setPackage(false);
//		productList.add(product2);
//
//		Product product3 = new Product();
//		product1.setName("EpsonABC Series Printer");
//		product1.setDescription("Laser printer");
//		product1.setAmount(12);
//		product1.setPrice(12);
//		product1.setCategoryId(0);
//		product1.setPackage(false);
//		productList.add(product3);
//
//		Product product4 = new Product();
//		product1.setName("Almond m&m milk chocolate bar");
//		product1.setDescription("almond and milk chocolate bar");
//		product1.setAmount(6);
//		product1.setPrice(35);
//		product1.setCategoryId(0);
//		product1.setPackage(false);
//		productList.add(product4);

		productRepository.saveAll(productList);
	}

	public static void main(String[] args) {
		SpringApplication.run(AssignmentJavaBootCampApplication.class, args);
	}

}
