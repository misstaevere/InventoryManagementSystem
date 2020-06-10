package com.qa.connecting.exceptions;

public class ConnectionNotMadeException extends RuntimeException {

	private final String MESSAGE;

	public ConnectionNotMadeException(String message) {
		super();
		this.MESSAGE = message;
	}

	@Override
	public String getMessage() {
		return MESSAGE;
	}
	
}
