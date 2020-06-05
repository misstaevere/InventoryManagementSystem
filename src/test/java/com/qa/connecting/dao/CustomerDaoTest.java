package com.qa.connecting.dao;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.connecting.model.Customer;

public class CustomerDaoTest {

	static DatabaseConnection databaseConnection;
	static final String SCHEMA_LOCATION = "src/test/resources/ims-project-schema.sql";
	static final String DATA_LOCATION = "src/test/resources/ims-project-data.sql";
	static final String CLEAR_LOCATION = "src/test/resources/ims-project-deleteDB.sql";
	static final String TERMINATE_LOCATION = "src/test/resources/ims-project-terminateDB.sql";

	// Reading through the files with the BufferedReader, we car read any file and
	// execute it on our testdb
	private static void sendToDB(Connection connection, String fileLocation) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
			String string;
			while ((string = br.readLine()) != null) {
				try (Statement statement = connection.createStatement();) {
					statement.executeUpdate(string);
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public static void init() throws SQLException {
		sendToDB(DriverManager.getConnection("jdbc:mysql://127.0.0.1", "root", "root"),
				SCHEMA_LOCATION);
	}

	@Before
	public void setup() { //
		databaseConnection = new TestingDatabaseConnection("root", "root");
		sendToDB(databaseConnection.getConnection(), DATA_LOCATION);
	}

	@After
	public void teardown() throws SQLException { // testing DB connection
		sendToDB(DriverManager.getConnection("jdbc:mysql://127.0.0.1/testdb", "root", "root"),
				CLEAR_LOCATION);
	}

	@AfterClass
	public static void terminate() throws SQLException {
		sendToDB(DriverManager.getConnection("jdbc:mysql://127.0.0.1", "root", "root"),
				TERMINATE_LOCATION);
		databaseConnection.closeConnection();
	}

	@Test
	public void test() throws SQLException {
		CustomerDao customerdao = new CustomerDao(databaseConnection); // instance of a class we are testing
		Customer test = new Customer(0, "Rosa", "Rudd", "rosa@gmail.com", "ilovemydog");
		customerdao.insertCustomer(test); // executing the method

		String query = "SELECT * FROM customer"; // all below is to verify it worked correctly
		ResultSet rs = databaseConnection.sendQuery(query);

		int count = 0;
		while (rs.next()) {
			count++;
		}

		assertEquals(4, count);
	}
}
