package com.qa.connecting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import com.qa.connecting.exceptions.SqlStatementNotUnderstoodException;

public abstract class DatabaseConnection implements Openable, Closeable, Queryable {
	
	public static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class);

	private Connection connection;
	private String username;
	private String password;

	public DatabaseConnection(String username, String password) {
		this.username = username;
		this.password = password;
		openConnection();
	}

	/* closing a connection helps save resources in our application */
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet sendQuery(String sql) {
		try {
			Statement statement = connection.createStatement();			
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			throw new SqlStatementNotUnderstoodException("Could not query with " + sql);
		} finally {
			closeConnection();
		}
	}

	public void sendUpdate(String sql) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			throw new SqlStatementNotUnderstoodException("Could not query with " + sql);
		}
	}
	
	public PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return connection.prepareStatement(sql);
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
