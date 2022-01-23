package com.digitalhonors.restweb.processpension.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digitalhonors.restweb.processpension.common.PensionerDetail;
import com.digitalhonors.restweb.processpension.common.TransactionRequest;
import com.digitalhonors.restweb.processpension.common.TransactionResponse;
import com.digitalhonors.restweb.processpension.service.ProcessPensionService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ProcessPensionController {
		
	@Autowired
	private ProcessPensionService processPensionService; 

	@PostMapping("/processPension")
	public TransactionResponse calculatePension(@RequestBody TransactionRequest request) {
		return processPensionService.calculatePensionAmount(request);
	}
	
	//findAllPensioners
	@GetMapping("/pensionerDetails")
	public List<PensionerDetail> findAllPensioners() {
		return processPensionService.findAllPensioners();
	}
}
