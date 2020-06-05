package com.qa.connecting.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.connecting.exceptions.ConnectionNotMadeException;
import com.qa.connecting.exceptions.SqlStatementNotUnderstoodException;

public abstract class DatabaseConnection implements Openable, Closeable, Queryable {

	private Connection connection;
	private String username;
	private String password;

	public DatabaseConnection(String username, String password) {
		this.username = username;
		this.password = password;
		openConnection();
	}

	
	// next 2 methods override same methods in Connectable
	public abstract void openConnection();

	// closing a connection helps save resources in our application
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet sendQuery(String sql) {
		try {
			Statement statement = connection.createStatement();			
			ResultSet resultSet = statement.executeQuery(sql);
			statement.close();
			return resultSet;
		} catch (SQLException e) {
			throw new SqlStatementNotUnderstoodException("Could not query with " + sql);
		}
	}

	public void sendUpdate(String sql) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SqlStatementNotUnderstoodException("Could not query with " + sql);
		}
	}


	public Connection getConnection() {
		return connection;
	}


	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
