package com.example.student.studentApplication.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;
	private String subjectCode;
	private String subjectName;
	private String score;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="student_id", nullable = false)
	@JsonIgnoreProperties("subject")
	private StudentSignup signup;

}
