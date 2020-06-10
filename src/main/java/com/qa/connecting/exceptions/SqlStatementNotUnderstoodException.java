package com.qa.connecting.exceptions;

public class SqlStatementNotUnderstoodException extends RuntimeException {
	
	private final String MESSAGE;

	public SqlStatementNotUnderstoodException(String message) {
		super();
		this.MESSAGE = message;
	}

	@Override
	public String getMessage() {
		return MESSAGE;
	}

}
