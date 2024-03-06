package com.example.student.studentApplication.Repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.student.studentApplication.Dto.SubjectDto;
import com.example.student.studentApplication.Entity.Subject;

public interface SubjectRepo extends JpaRepository<Subject,Integer>{
	
	 @Query(value ="SELECT DISTINCT s.signup.student_name FROM subject s WHERE NOT EXISTS " +
	           "(SELECT sub FROM subject sub WHERE sub.signup = s.signup AND UPPER(sub.score) <> 'P')", nativeQuery = true)
	   public List<String> findStudentNamesWithAllPassScores();
	 
	 @Query(value ="SELECT DISTINCT s.signup.name FROM Subject s WHERE s.signup NOT IN " +
	           "(SELECT sub.signup FROM Subject sub WHERE UPPER(sub.score) = 'P')", nativeQuery = true)
	    List<String> findStudentNamesWithAtLeastOneFailScore();
	 
	 
	 @Query(value ="SELECT s.signup.department as department, NEW map(s.subjectName as subjectName, s.subjectCode as subjectCode) FROM Subject s", nativeQuery = true)
	    Map<String, SubjectDto> findSubjectsGroupedByDepartments();
}
