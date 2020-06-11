package com.qa.connecting.exceptions;

public class NotFoundException extends RuntimeException {

	private final String MESSAGE;

	public NotFoundException(String message) {
		this.MESSAGE = message;
	}

	@Override
	public String getMessage() {
		return MESSAGE;
	}
}
