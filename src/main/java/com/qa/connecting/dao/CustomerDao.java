package com.qa.connecting.dao;

import com.qa.connecting.model.Customer;

public class CustomerDao { // DATA ACCESS OBJECT - WILL BE SENDING DATA

	private DatabaseConnection databaseConnection;

	public CustomerDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertCustomer(Customer customer) { // METHOD TO ADD CUSTOMERS DATA, // STRING
													// CATENATION
		// " " to declare int, + '' for strings = 1, 'Piers',
		String sql = "INSERT INTO customer VALUES (" + customer.getCustomer_ID() + ",'"
				+ customer.getCustomer_first_name() + "','" + customer.getCustomer_last_name() + "','"
				+ customer.getCustomer_email() + "','" + customer.getCustomer_password() + "')";

		databaseConnection.sendUpdate(sql);
	}

	private void selectAllCustomers(Customer customer) {
		String sql = "SELECT * FROM Customer";
	}

	private void describeCustomer(Customer customer) {
		String sql = "DESCRIBE customer";
	}
	
	private void selectCustomerByNameAndID(Customer customer) {
		String sql = "SELECT customer_first_name, customer_email FROM customer";
	}
	
	private void selectCustomerWhereFirstNameEndsWithS(Customer customer) {
		String sql = "SELECT * from customer WHERE customer_first_name LIKE '%s'";
	}
}
