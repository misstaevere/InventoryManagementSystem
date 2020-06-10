package com.qa.connecting.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.qa.connecting.exceptions.SqlStatementNotUnderstoodException;

public class RemoteDatabaseConnection extends DatabaseConnection {

	public RemoteDatabaseConnection(String username, String password) {
		super(username, password);
	}

	/*
	 * CREATE A CONSTRUCTOR TO MAKE SURE THE CODE RUNS EVERY TIME THERE IS A BASE
	 * CONNECTION
	 */
	public void openConnection() { /* only hardcode URL for security */
		/* protocol:driver(mvn dependencies) */
		try {
			setConnection(
					DriverManager.getConnection("jdbc:mysql://34.105.176.129/shopdb", getUsername(), getPassword()));
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			throw new SqlStatementNotUnderstoodException("Connection unsuccessful");
		} 
	}
}
