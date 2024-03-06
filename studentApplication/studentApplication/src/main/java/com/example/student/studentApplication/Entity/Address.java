package com.example.student.studentApplication.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private String doorNo;
	private String area;
	private String city;
	private String state;
	private int pincode;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="student_id", nullable = false)
	@JsonIgnoreProperties("address")
	private StudentSignup signup;
	
}
