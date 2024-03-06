package com.example.student.studentApplication.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.studentApplication.Dto.SubjectDto;
import com.example.student.studentApplication.Entity.StudentSignup;
import com.example.student.studentApplication.Entity.Subject;
import com.example.student.studentApplication.Repo.StudentRepo;
import com.example.student.studentApplication.Repo.SubjectRepo;
import com.example.student.studentApplication.Service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	private SubjectRepo subjectRepo;
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public String createSubject(Subject subject) {
		
		subjectRepo.save(subject);
		
		// TODO Auto-generated method stub
		return "Subject created Sucessfully";
	}

	@Override
	public String updateSubject(Subject subject) {
		
		if(subjectRepo.existsById(subject.getSubjectId())) {
			Subject addSubject = new Subject();
			addSubject.setSubjectId(subject.getSubjectId());
			addSubject.setSubjectCode(subject.getSubjectCode());
			addSubject.setSubjectName(subject.getSubjectName());
			addSubject.setScore(subject.getScore());
			
			subjectRepo.save(addSubject);
			return "Subject updated sucessfully";
		}
		// TODO Auto-generated method stub
		return "Not Updated";
	}

	@Override
	public List<String> filterPassCandidates() {
		// TODO Auto-generated method stub
		List<StudentSignup> getAllStudent = studentRepo.findAll();
		List<String> passStudents= new ArrayList<>();
		for (StudentSignup student : getAllStudent) {
			boolean allScoresArePass = student.getSubject().stream()
					.allMatch(score -> score.getScore().toLowerCase().equals("p"));
			if(allScoresArePass) {
				passStudents.add(student.getStudentName());
			}
		}
		
		if(passStudents.isEmpty()) {
			return null;
		}
		return passStudents;
	}

	@Override
	public List<String> filterFailedCandidates() {
		List<StudentSignup> getAllStudent = studentRepo.findAll();
		List<String> failStudents= new ArrayList<>();
		for (StudentSignup student : getAllStudent) {
			boolean anyScoresisFail = student.getSubject().stream()
					.anyMatch(score -> score.getScore().toLowerCase().equals("f"));
					
			if(anyScoresisFail) {
				failStudents.add(student.getStudentName());
			}
		}
		if(failStudents.isEmpty()) {
			return null;
		}
		return failStudents;
	
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, List<SubjectDto>> getSubjectListBasedOnAllDepartment() {
		List<Subject> getAllSubject = subjectRepo.findAll();
		Map<String, List<SubjectDto>> getSubjectListBasedOnAllDepartment = new HashMap<>();

		for (Subject subject : getAllSubject) {
			String department = subject.getSignup().getDepartment();
			SubjectDto subjectDetail = new SubjectDto();
			subjectDetail.setSubjectId(subject.getSubjectId());
			subjectDetail.setSubjectCode(subject.getSubjectCode());
			subjectDetail.setSubjectName(subject.getSubjectName());

			getSubjectListBasedOnAllDepartment.putIfAbsent(department, new ArrayList<>());

			getSubjectListBasedOnAllDepartment.get(department).add(subjectDetail);
		}
		
		if(getSubjectListBasedOnAllDepartment.isEmpty()) {
			return null;
		}
		return getSubjectListBasedOnAllDepartment;
		
		// TODO Auto-generated method stub
		
	}

	
}
