package com.digitalhonors.restweb.processpension.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROCESS_PENSION")
public class ProcessPension {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double pensionAmount;
	private double bankServiceCharge;
	private Long pensionerId;

	public ProcessPension() {
	}

	public ProcessPension(double pensionAmount, double bankServiceCharge, Long pensionerId) {
		this.pensionAmount = pensionAmount;
		this.bankServiceCharge = bankServiceCharge;
		this.pensionerId = pensionerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPensionAmount() {
		return pensionAmount;
	}

	public void setPensionAmount(double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}

	public double getBankServiceCharge() {
		return bankServiceCharge;
	}

	public void setBankServiceCharge(double bankServiceCharge) {
		this.bankServiceCharge = bankServiceCharge;
	}

	public Long getPensionerId() {
		return pensionerId;
	}

	public void setPensionerId(Long pensionerId) {
		this.pensionerId = pensionerId;
	}
	
	

}
