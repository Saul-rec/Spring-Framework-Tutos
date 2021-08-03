package com.example.demoStudentApi.Student;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepo;

	@Autowired
	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	public List<Student> getStudents() {
		return studentRepo.findAll();

	}

	public ResponseEntity<Object> getStudentById(Long id) {
		return new ResponseEntity<>(studentRepo.findById(id), HttpStatus.FOUND);
	}

	public ResponseEntity<Object> createStudent(Student student) {
		studentRepo.save(student);
		return new ResponseEntity<>("Student was inserted successfully", HttpStatus.CREATED);
	}

}
