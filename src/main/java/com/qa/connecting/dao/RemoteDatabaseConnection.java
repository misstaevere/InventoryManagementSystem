package com.qa.connecting.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

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
			System.out.println("Piers Confused");
			e.printStackTrace();
		}
	}
}
