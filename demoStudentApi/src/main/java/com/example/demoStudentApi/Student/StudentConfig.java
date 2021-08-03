package com.example.demoStudentApi.Student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student mariam = new Student("Mariam", "some@gmail.com", LocalDate.of(2000, 1, 2), 21);

			Student alex = new Student("Alex", "alex.example@gmail.com", LocalDate.of(2000, 4, 8), 21);
			repository.saveAll(List.of(mariam, alex));
		};

	}

}
