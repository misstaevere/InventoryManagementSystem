package com.qa.connecting.dao;

import java.sql.DriverManager;

import java.sql.SQLException;
import com.qa.connecting.exceptions.ConnectionNotMadeException;

public class TestingDatabaseConnection extends DatabaseConnection { // same as remote but uses testdb

	public TestingDatabaseConnection(String username, String password) {
		super(username, password);
	}

	public void openConnection() {
		
		try {
			setConnection(DriverManager.getConnection("jdbc:mysql://127.0.0.1/testdb", getUsername(), getPassword()));
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			throw new ConnectionNotMadeException("Local database is not accessible: " + e.getMessage());
		}
	}
	
}
