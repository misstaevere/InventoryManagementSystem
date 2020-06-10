package com.qa.connecting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.connecting.exceptions.NotFoundException;
import com.qa.connecting.model.Customer;

public class CustomerDao { // DATA ACCESS OBJECT - WILL BE SENDING DATA

	private DatabaseConnection databaseConnection;

	public static final Logger LOGGER = Logger.getLogger(CustomerDao.class);

	public CustomerDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertCustomer(Customer customer) { // METHOD TO ADD CUSTOMERS DATA, // STRING
													// CATENATION
		// " " to declare int, + '' for strings = 1, 'Piers',
		String sql = "INSERT INTO customer (customer_first_name, customer_last_name, customer_email, customer_password) VALUES ('"
				+ customer.getCustomerForeName() + "','" + customer.getCustomerLastName() + "','"
				+ customer.getCustomerEmail() + "','" + customer.getCustomerPassword() + "')";

		databaseConnection.sendUpdate(sql);
		LOGGER.info("New customer was successfully added!");
	}

	public List<Customer> selectCustomerByName(Customer customer) throws SQLException {
		String sql = "SELECT * FROM customer WHERE customer_first_name = '" + customer.getCustomerForeName()
				+ "' AND customer_last_name = '" + customer.getCustomerLastName() + "'";
		ResultSet rs = databaseConnection.sendQuery(sql);
		List<Customer> customers = new ArrayList<Customer>();
		if (rs.next()) {
			rs.beforeFirst();
			while (rs.next()) {
				Customer temp = new Customer();
				temp.setCustomerID(rs.getInt("customer_ID"));
				temp.setCustomerForeName(rs.getString("customer_first_name"));
				temp.setCustomerLastName(rs.getString("customer_last_name"));
				temp.setCustomerEmail(rs.getString("customer_email"));
				temp.setCustomerPassword(rs.getString("customer_password"));

				customers.add(temp);
			}
		} else {
			throw new NotFoundException("Customer not found");
		}
		
		return customers;
	
	}

	public void updateCustomerName(Customer customer) throws SQLException {
		String sql = "UPDATE customer SET customer_first_name=? WHERE customer_ID=?";

		PreparedStatement statement = databaseConnection.getPreparedStatement(sql);
		statement.setString(1, customer.getCustomerForeName());
		statement.setLong(2, customer.getCustomerID());

		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
			LOGGER.info("An existing customer was successfully updated!");
		}

	}

	public void deleteCustomer(String firstName) throws SQLException {

		String sql = "DELETE FROM customer WHERE customer_first_name=?";

		PreparedStatement statement = databaseConnection.getPreparedStatement(sql);
		statement.setString(1, firstName);

		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
			LOGGER.info("User records were successfully deleted!");
		}
	}
}
