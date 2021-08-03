package com.example.demoStudentApi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class DemoStudentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStudentApiApplication.class, args);
	}
	

}
