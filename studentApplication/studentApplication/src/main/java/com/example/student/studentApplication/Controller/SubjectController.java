package com.example.student.studentApplication.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.studentApplication.Dto.SubjectDto;
import com.example.student.studentApplication.Entity.Subject;
import com.example.student.studentApplication.Service.SubjectService;

@RestController
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/create-subject")
	public String createSubject(@RequestBody Subject subject) {
		return subjectService.createSubject(subject);
	}
	@PatchMapping("/update-subject")
	public String updateSubject(@RequestBody Subject subject) {
		return subjectService.updateSubject(subject);
	}
	@GetMapping("/getPass")
	public List<String> filterPassCandidates(){
		return subjectService.filterPassCandidates();
	}
	
	@GetMapping("/getfail")
	public List<String> filterFailedCandidates(){
		return subjectService.filterFailedCandidates();
	}
	
	@GetMapping("/getSubjectListBasedOnAllDepartment")
	public Map<String,List<SubjectDto>> getSubjectListBasedOnAllDepartment(){
		return subjectService.getSubjectListBasedOnAllDepartment();
	}
	
}
