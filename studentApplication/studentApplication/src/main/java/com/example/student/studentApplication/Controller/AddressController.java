package com.example.student.studentApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.studentApplication.Entity.Address;
import com.example.student.studentApplication.Service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PatchMapping("/updateAddress")
	public String updateAddressData(@RequestBody Address addressData) {
		
		return addressService.updateAddressData(addressData);
		
	}
	@GetMapping("/getAddressBasedOnDetail")
	public List<Address> getAllStudentDataBasedOnAnyAddressDetails(@RequestHeader String addressDetails){
		return addressService.getAllStudentDataBasedOnAnyAddressDetails(addressDetails);
	}
	

}
