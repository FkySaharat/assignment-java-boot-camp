package com.example.assignmentjavabootcamp;

import com.example.assignmentjavabootcamp.Product.Service.InitialProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AssignmentJavaBootCampApplication {

	@Autowired
	private InitialProductService  initialProductService;

	@PostConstruct
	public  void initialData(){
		initialProductService.initialData();
	}

	public static void main(String[] args) {
		SpringApplication.run(AssignmentJavaBootCampApplication.class, args);
	}

}
