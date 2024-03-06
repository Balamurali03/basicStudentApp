package com.example.student.studentApplication.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.studentApplication.Entity.StudentSignup;
import com.example.student.studentApplication.Repo.StudentRepo;
import com.example.student.studentApplication.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public String signupData(StudentSignup signupData) {
		// TODO Auto-generated method stub
		boolean check = studentRepo.existsById(signupData.getStudentId());
		if (check == true) {
			return "user Already Exist";
		} else {

		}
		return null;
	}

	@Override
	public String updateStudentData(StudentSignup signupData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loginData(String data, String password) {
		StudentSignup student = studentRepo.findByUsernameOrEmail(data);
		if (student != null) {
			if (student.getPassword().equals(password)) {
				return "Login sucessful";
			} else {
				return "Login unsucessful Password incorrect";
			}
		}
		// TODO Auto-generated method stub
		return "user not exist";
	}

	@Override
	public StudentSignup getStudentDataByUserName(String userName) {
		StudentSignup student = studentRepo.findByUsernameOrEmail(userName);

		// TODO Auto-generated method stub
		return student;
	}

	@Override
	public String deleteStudentDataByUserName(String userName) {

		StudentSignup student = studentRepo.findByUsernameOrEmail(userName);
		studentRepo.delete(student);
		// TODO Auto-generated method stub
		return "Student data deleted sucessful";
	}

	@Override
	public List<StudentSignup> getAllStudentData() {
		List<StudentSignup> getAllStudent = studentRepo.findAll();
		if (getAllStudent.isEmpty()) {
			return null;
		}
		// TODO Auto-generated method stub
		return getAllStudent;
	}

	@Override
	public Map<String, List<String>> getStudentNameListBasedOnAllDepartments() {
		List<StudentSignup> getAllStudent = studentRepo.findAll();
		Map<String, List<String>> getStudentNameListBasedOnAllDepartments = new HashMap<>();

		for (StudentSignup student : getAllStudent) {
			String department = student.getDepartment();
			String studentName = student.getStudentName();

			getStudentNameListBasedOnAllDepartments.putIfAbsent(department, new ArrayList<>());

			getStudentNameListBasedOnAllDepartments.get(department).add(studentName);
		}

		// TODO Auto-generated method stub
		return getStudentNameListBasedOnAllDepartments;
	}

}
