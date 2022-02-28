package com.example.assignmentjavabootcamp;

import com.example.assignmentjavabootcamp.Product.Repository.ProductRepository;
import com.example.assignmentjavabootcamp.Product.Service.InitialProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AssignmentJavaBootCampApplication {

	@Autowired
	private ProductRepository productRepository;

	@PostConstruct
	public  void initialData(){
		InitialProductService  initialProductService = new InitialProductService();
		initialProductService.setProductRepository(productRepository);
		initialProductService.initialData();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(AssignmentJavaBootCampApplication.class, args);

		System.out.println(context.getBeanDefinitionCount());
	}

}
