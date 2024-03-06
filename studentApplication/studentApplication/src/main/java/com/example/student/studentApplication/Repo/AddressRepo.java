package com.example.student.studentApplication.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.student.studentApplication.Entity.Address;

public interface AddressRepo extends JpaRepository<Address,Integer> {

	
	@Query(value = "SELECT * FROM Address u WHERE city = :data OR state=:data OR area= :data OR pincode = :data", nativeQuery = true) 
	public List<Address> getListBasedOnAddressDetails(String data);

}
