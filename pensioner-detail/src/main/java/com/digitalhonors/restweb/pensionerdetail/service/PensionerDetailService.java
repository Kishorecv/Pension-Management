package com.digitalhonors.restweb.pensionerdetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.digitalhonors.restweb.pensionerdetail.exception.ResourceException;
import com.digitalhonors.restweb.pensionerdetail.model.PensionerDetail;
import com.digitalhonors.restweb.pensionerdetail.repository.PensionerDetailRepository;

@Service
public class PensionerDetailService {
	
	@Autowired
	private PensionerDetailRepository pensionerRepo;
	
	
	public PensionerDetail savePensioner(Long aadhaarNumber){
		PensionerDetail pensionerDetail = pensionerRepo.findByAadhaarNumber(aadhaarNumber);
		if(pensionerDetail == null){
			throw new ResourceException("Invalid Aadhaar Number. Please try again!");
			//throw new RuntimeException("Unable to find the data for " + aadhaarNumber);
		}
		return pensionerDetail;
		
	}

}
