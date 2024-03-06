package com.example.student.studentApplication.Service;

import java.util.List;
import java.util.Map;

import com.example.student.studentApplication.Dto.SubjectDto;
import com.example.student.studentApplication.Entity.Subject;

public interface SubjectService {
	
	public String createSubject(Subject subject);
	public String updateSubject(Subject subject);
	public List<String> filterPassCandidates();
	public List<String> filterFailedCandidates();
	public Map<String,List<SubjectDto>> getSubjectListBasedOnAllDepartment();
	

}
