package com.example.student.studentApplication.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class StudentSignup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int studentId;
	private String studentName;
	
	@Column(name = "username",unique = true)
	private String studentUsername;
	private String email;
	private long phNo;
	private int age;
	private String password;
	private String department;
	
	@OneToOne(mappedBy = "signup", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("signup")
	private Address address;
	
	@OneToMany(mappedBy = "signup", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("signup")
	private List<Subject> subject;

}
