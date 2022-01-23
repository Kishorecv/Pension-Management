package com.digitalhonors.restweb.pensionerdetail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.digitalhonors.restweb.pensionerdetail.model.PensionerDetail;
import com.digitalhonors.restweb.pensionerdetail.repository.PensionerDetailRepository;
import com.digitalhonors.restweb.pensionerdetail.service.PensionerDetailService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PensionerDetailController {
	@Autowired
	private PensionerDetailRepository pdRepository;
	
	@Autowired 
	private PensionerDetailService pensionerDetailService;
	
	@GetMapping("/pensionerDetailByAadhaar/{aadhaarNumber}")
	public PensionerDetail retrievePensionerDetail(@PathVariable Long aadhaarNumber) {
		return pensionerDetailService.savePensioner(aadhaarNumber);
	}
	
	@GetMapping("/pensionerDetails")
	public List<PensionerDetail> retrieveAllPensionerDetails() {
		return (List<PensionerDetail>) pdRepository.findAll();
	}

}
