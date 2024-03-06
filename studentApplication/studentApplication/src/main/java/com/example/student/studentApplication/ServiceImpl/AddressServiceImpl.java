package com.example.student.studentApplication.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.studentApplication.Entity.Address;
import com.example.student.studentApplication.Repo.AddressRepo;
import com.example.student.studentApplication.Service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepo addressRepo;

	@Override
	public String updateAddressData(Address addressData) {
		if(addressRepo.existsById(addressData.getAddressId())) {
			Address address= new Address();
			address.setArea(addressData.getArea());
			address.setCity(addressData.getCity());
			address.setDoorNo(addressData.getDoorNo());
			address.setPincode(addressData.getPincode());
			address.setState(addressData.getState());
			
			addressRepo.save(address);
			
			return "Address Updated Sucessfully";
		}
		else {
			return "Not Updated";
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Address> getAllStudentDataBasedOnAnyAddressDetails(String addressDetails) {
		
		List<Address> address= addressRepo.getListBasedOnAddressDetails(addressDetails);
		if(address.isEmpty()) {
			return null;
		}
		else {
			return address;
		}
		// TODO Auto-generated method stub
		
	}
	
}
