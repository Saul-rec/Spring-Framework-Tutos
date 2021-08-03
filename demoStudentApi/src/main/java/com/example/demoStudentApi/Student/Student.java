package com.example.demoStudentApi.Student;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
			)
	private Long id;
	private String name;
	private String mail;
	private LocalDate dob;
	private Integer age;

	public Student() {
		

	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mail=" + mail + ", dob=" + dob + ", age=" + age + "]";
	}

	public Student(Long id, String name, String mail, LocalDate dob, Integer age) {
	
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.dob = dob;
		this.age = age;
	}
	
	public Student(String name, String mail, LocalDate dob, Integer age) {
		this.name = name;
		this.mail = mail;
		this.dob = dob;
		this.age = age;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}



}
