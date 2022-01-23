package com.digitalhonors.restweb.processpension.common;

public class TransactionResponse {
	
	private PensionerDetail pensionerDetail;
	private double pensionAmount;
	private double bankServiceCharge;
	private Long pensionerId;
	private String message;
	
	public TransactionResponse() {	}

	public TransactionResponse(PensionerDetail pensionerDetail, double pensionAmount, double bankServiceCharge,
			Long pensionerId, String message) {
		super();
		this.pensionerDetail = pensionerDetail;
		this.pensionAmount = pensionAmount;
		this.bankServiceCharge = bankServiceCharge;
		this.pensionerId = pensionerId;
		this.message = message;
	}

	public PensionerDetail getPensionerDetail() {
		return pensionerDetail;
	}

	public void setPensionerDetail(PensionerDetail pensionerDetail) {
		this.pensionerDetail = pensionerDetail;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
