package com.goodTime.exception;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException{
	
	private String message;

	public BadRequestException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
