package com.example.demoStudentApi.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoStudentApi.ExceptionHandler.ResourceNotFoundException;

@RestController

public class StudentController {
	@Autowired
	private final StudentService studservice;
	@Autowired
	private StudentRepository repo;

	public StudentController(StudentService studservice) {
		this.studservice = studservice;
	}

	@GetMapping(value = "api/v1/student")
	public List<Student> getStudents() {
		return studservice.getStudents();
	}

	@GetMapping(value = "api/v1/student/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable("id") Long id) throws ResourceNotFoundException {

		if (repo.findById(id).isEmpty())
			throw new ResourceNotFoundException("Not Found id");
		return studservice.getStudentById(id);
	}

	@RequestMapping(value = "api/v1/student", method = RequestMethod.POST)
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		return studservice.createStudent(student);
	}

}
