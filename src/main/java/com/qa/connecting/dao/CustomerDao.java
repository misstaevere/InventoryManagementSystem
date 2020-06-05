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
		String sql = "INSERT INTO customer (customer_first_name, customer_last_name, customer_email, customer_password) VALUES (" 
				+ customer.getCustomer_first_name() + "','" + customer.getCustomer_last_name() + "','"
				+ customer.getCustomer_email() + "','" + customer.getCustomer_password() + "')";

		databaseConnection.sendUpdate(sql);
	}

	private void selectAllCustomers() {
		String sql = "SELECT * FROM Customer";
	}

	private void describeCustomer() {
		String sql = "DESCRIBE customer";
	}
	
	private void selectCustomerByName(Customer customer) {
		String sql = "SELECT customer_first_name, customer_email FROM customer where customer_first_name="+customer.getCustomer_first_name();
	}
	
	private void selectCustomerWhereFirstNameEndsWithS(Customer customer) {
		String sql = "SELECT * from customer WHERE customer_first_name LIKE '%s'";
	}
}
