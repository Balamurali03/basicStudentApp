package com.example.student.studentApplication.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.student.studentApplication.Entity.StudentSignup;

public interface StudentRepo extends JpaRepository<StudentSignup,Integer>{
	
	@Query(value = "SELECT * FROM StudentSignup u WHERE email = :data OR username=:data", nativeQuery = true) 
	public StudentSignup findByUsernameOrEmail(String data);
	
//	@Query(value = "SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM StudentSignup u WHERE email = :data OR username = :data", nativeQuery = true) 
//    public boolean existsByUsernameOrEmail( String data);

}
