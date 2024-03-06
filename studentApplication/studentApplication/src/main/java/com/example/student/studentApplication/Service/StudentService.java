package com.example.student.studentApplication.Service;

import java.util.List;
import java.util.Map;

import com.example.student.studentApplication.Entity.StudentSignup;

public interface StudentService {
	
	public String signupData(StudentSignup signupData);
	public String updateStudentData(StudentSignup signupData);
	public String loginData(String data,String password);
	public StudentSignup getStudentDataByUserName(String userName);
	public String deleteStudentDataByUserName(String userName);
	public List<StudentSignup> getAllStudentData();
	public Map<String,List<String>> getStudentNameListBasedOnAllDepartments();
	


}
