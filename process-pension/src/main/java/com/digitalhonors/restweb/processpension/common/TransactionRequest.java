package com.digitalhonors.restweb.processpension.common;

import com.digitalhonors.restweb.processpension.model.ProcessPension;

public class TransactionRequest {
	
		private PensionerDetail pensionerDetail;
		private ProcessPension processPension;
	
	public TransactionRequest() {	}
	
	public TransactionRequest(PensionerDetail pensionerDetail, ProcessPension processPension) {
		this.pensionerDetail = pensionerDetail;
		this.processPension = processPension;
	}
	

	public PensionerDetail getPensionerDetail() {
		return pensionerDetail;
	}

	public void setPensionerDetail(PensionerDetail pensionerDetail) {
		this.pensionerDetail = pensionerDetail;
	}

	public ProcessPension getProcessPension() {
		return processPension;
	}

	public void setProcessPension(ProcessPension processPension) {
		this.processPension = processPension;
	}
	
}
