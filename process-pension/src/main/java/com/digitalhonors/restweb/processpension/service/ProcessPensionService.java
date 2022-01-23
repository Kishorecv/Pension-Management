package com.digitalhonors.restweb.processpension.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.digitalhonors.restweb.processpension.common.PensionerDetail;
import com.digitalhonors.restweb.processpension.common.TransactionRequest;
import com.digitalhonors.restweb.processpension.common.TransactionResponse;
import com.digitalhonors.restweb.processpension.model.ProcessPension;
import com.digitalhonors.restweb.processpension.repository.ProcessPensionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProcessPensionService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ProcessPensionRepository processPensionrepository;

	/*
	 * public TransactionResponse calculatePensionAmount(TransactionRequest
	 * request) { String response = null; double bankServiceCharge; double
	 * pensionAmount; PensionerDetail pensionerDetail =
	 * request.getPensionerDetail(); ProcessPension processPension =
	 * request.getProcessPension();
	 * processPension.setPensionerId(pensionerDetail.getId()); Long aadharNumber
	 * = pensionerDetail.getAadharNumber();
	 * 
	 * String criterion = "{\"prop\":\"aadharNumber\"}"; String URL =
	 * "http://localhost:8000/pensionerDetailByAadhaar/get?criterion={criterion}";
	 * PensionerDetail pensionerDetailResponse = restTemplate.getForObject(URL,
	 * PensionerDetail.class);
	 * 
	 * HashMap<String, Long> uriVariables = new HashMap<>();
	 * uriVariables.put("aadharNumber", aadharNumber);
	 * ResponseEntity<PensionerDetail> responseEntity = new
	 * RestTemplate().getForEntity(
	 * "http://localhost:8000/pensionerDetailByAadhaar/{aadharNumber}",
	 * PensionerDetail.class, uriVariables); PensionerDetail
	 * pensionerDetailResponse = responseEntity.getBody(); if
	 * (pensionerDetailResponse.getPensionerName() != null) { response =
	 * "Pensioner Details Fetched based on Aadhaar Number : " + aadharNumber; }
	 * else { response = "There is a problem with fetching Pensioner Details"; }
	 * double salary = pensionerDetailResponse.getSalary(); double allowances =
	 * pensionerDetailResponse.getAllowances(); String pensionType =
	 * pensionerDetailResponse.getPensionType(); String bankType =
	 * pensionerDetailResponse.getBankType(); if
	 * (pensionType.equalsIgnoreCase("self")) { pensionAmount = 0.8 * salary +
	 * allowances; } else { pensionAmount = 0.5 * salary + allowances; } if
	 * (bankType.equalsIgnoreCase("Public Bank")) { bankServiceCharge = 500; }
	 * else { bankServiceCharge = 550; }
	 * processPension.setPensionAmount(pensionAmount);
	 * processPension.setBankServiceCharge(bankServiceCharge);
	 * processPensionrepository.save(processPension); return new
	 * TransactionResponse(pensionerDetailResponse, pensionAmount,
	 * bankServiceCharge, processPension.getPensionerId(), response);
	 * 
	 * // Calculate the pension based on Aadhar details
	 * 
	 * 
	 * HashMap<String, Long> uriVariables = new HashMap<>();
	 * uriVariables.put("aadharNumber", aadharNumber);
	 * ResponseEntity<ProcessPension> responseEntity = new
	 * RestTemplate().getForEntity(
	 * "http://localhost:8000/pensionerDetailByAadhaar/{aadharNumber}",
	 * ProcessPension.class, uriVariables);
	 * 
	 * 
	 * // ProcessPension processPension = responseEntity.getBody(); }
	 */

	public TransactionResponse calculatePensionAmount(TransactionRequest request) {
		String response = null;
		double bankServiceCharge;
		double pensionAmount;
		PensionerDetail pensionerDetail = request.getPensionerDetail();
		ProcessPension processPension = request.getProcessPension();
		Long aadhaarNumber = pensionerDetail.getAadhaarNumber();
		HashMap<String, Long> uriVariables = new HashMap<>();
		uriVariables.put("aadhaarNumber", aadhaarNumber);
		ResponseEntity<PensionerDetail> responseEntity = restTemplate.getForEntity(
				"http://PENSIONER-DETAIL/pensionerDetailByAadhaar/{aadhaarNumber}", PensionerDetail.class,
				uriVariables);
		PensionerDetail pensionerDetailResponse = responseEntity.getBody();
		Long pensionerId = pensionerDetailResponse.getId();
		
		if (pensionerDetailResponse.getPensionerName() != null) {
			response = "Pensioner Details Fetched based on Aadhaar Number : " + aadhaarNumber;
		} else {
			response = "There is a problem with fetching Pensioner Details";
		}
		double salary = pensionerDetailResponse.getSalary();
		double allowances = pensionerDetailResponse.getAllowances();
		String pensionType = pensionerDetailResponse.getPensionType();
		String bankType = pensionerDetailResponse.getBankType();
		if (pensionType.equalsIgnoreCase("self")) {
			pensionAmount = 0.8 * salary + allowances;
		} else {
			pensionAmount = 0.5 * salary + allowances;
		}
		if (bankType.equalsIgnoreCase("Public Bank")) {
			bankServiceCharge = 500;
		} else {
			bankServiceCharge = 550;
		}
		processPension.setPensionAmount(pensionAmount);
		processPension.setBankServiceCharge(bankServiceCharge);
		processPension.setPensionerId(pensionerId);
		processPensionrepository.save(processPension);
		return new TransactionResponse(pensionerDetailResponse, pensionAmount, bankServiceCharge, pensionerId,
				response);
	}

	public List<PensionerDetail> findAllPensioners() {
		ResponseEntity<PensionerDetail[]> responseEntity = restTemplate
				.getForEntity("http://PENSIONER-DETAIL/pensionerDetails", PensionerDetail[].class);
		PensionerDetail[] pensionerDetailList = responseEntity.getBody();
		ObjectMapper mapper = new ObjectMapper();
		return Arrays.stream(pensionerDetailList)
				.map(pensionerDetail -> mapper.convertValue(pensionerDetail, PensionerDetail.class))
				.collect(Collectors.toList());
	}

}
