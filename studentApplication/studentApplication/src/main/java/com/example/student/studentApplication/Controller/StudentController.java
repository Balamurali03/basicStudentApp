package com.example.student.studentApplication.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.studentApplication.Entity.StudentSignup;
import com.example.student.studentApplication.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/login")
	public String loginData(@RequestHeader String data,@RequestHeader String password) {
		return studentService.loginData(data, password);
	}
	@GetMapping("/by-username")
	public StudentSignup getStudentDataByUserName(@RequestHeader String userName) {
		return studentService.getStudentDataByUserName(userName);
	}
	@DeleteMapping("/delete")
	public String deleteStudentDataByUserName(@RequestHeader String userName) {
		return studentService.deleteStudentDataByUserName(userName);
	}
	@GetMapping("/all-student-list")
	public List<StudentSignup> getAllStudentData(){
		return studentService.getAllStudentData();
	}
	@GetMapping("/student-based-on-department")
	public Map<String,List<String>> getStudentNameListBasedOnAllDepartments(){
		return studentService.getStudentNameListBasedOnAllDepartments();
	}

}
