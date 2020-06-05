package com.qa.connecting.model; // MODELS OUR DATA

public class Customer {

	private int customer_ID = 0;
	private String customer_first_name;
	private String customer_last_name;
	private String customer_email;
	private String customer_password;
	
	public Customer(int customer_ID, String customer_first_name, String customer_last_name, String customer_email,
			String customer_password) {
		super();
		this.customer_ID = customer_ID;
		this.customer_first_name = customer_first_name;
		this.customer_last_name = customer_last_name;
		this.customer_email = customer_email;
		this.customer_password = customer_password;
	}

	public int getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public String getCustomer_first_name() {
		return customer_first_name;
	}

	public void setCustomer_first_name(String customer_first_name) {
		this.customer_first_name = customer_first_name;
	}

	public String getCustomer_last_name() {
		return customer_last_name;
	}

	public void setCustomer_last_name(String customer_last_name) {
		this.customer_last_name = customer_last_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
}
