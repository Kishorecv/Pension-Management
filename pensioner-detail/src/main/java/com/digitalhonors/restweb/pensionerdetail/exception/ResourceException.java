package com.digitalhonors.restweb.pensionerdetail.exception;

import org.springframework.http.HttpStatus;

public class ResourceException extends RuntimeException {
	
	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	private String message;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

	public ResourceException(String message) {
		super(message);
		this.message = message;
	}
    
/*	 public ResourceException(HttpStatus httpStatus, String message) {
	        super(message);
	        this.httpStatus = httpStatus;
	    }*/

}
