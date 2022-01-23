package com.digitalhonors.restweb.pensionerdetail.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "PensionerDetail")
public class PensionerDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String pensionerName;
	@Column(name = "aadhaar_number")
	private Long aadhaarNumber;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dob;
	private String pan;
	private double salary;
	private double allowances;
	private String pensionType;
	private String bankName;
	private Long accountNumber;
	private String bankType;

	public PensionerDetail() {
	}

	public PensionerDetail(Long id, String pensionerName, Long aadhaarNumber, Date dob, String pan, double salary,
			double allowances, String pensionType, String bankName, Long accountNumber, String bankType) {
		super();
		this.id = id;
		this.pensionerName = pensionerName;
		this.aadhaarNumber = aadhaarNumber;
		this.dob = dob;
		this.pan = pan;
		this.salary = salary;
		this.allowances = allowances;
		this.pensionType = pensionType;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.bankType = bankType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPensionerName() {
		return pensionerName;
	}

	public void setPensionerName(String pensionerName) {
		this.pensionerName = pensionerName;
	}

	public Long getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(Long aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getAllowances() {
		return allowances;
	}

	public void setAllowances(double allowances) {
		this.allowances = allowances;
	}

	public String getPensionType() {
		return pensionType;
	}

	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
}
