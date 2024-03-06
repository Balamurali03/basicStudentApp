package com.example.student.studentApplication.Service;

import java.util.List;

import com.example.student.studentApplication.Entity.Address;

public interface AddressService {
	
	public String updateAddressData(Address addressData);
	public List<Address> getAllStudentDataBasedOnAnyAddressDetails(String addressDetails);
	
}
