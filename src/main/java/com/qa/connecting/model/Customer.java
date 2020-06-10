package com.qa.connecting.model; // MODELS OUR DATA

public class Customer {

	private int customerID;
	private String foreName;
	private String lastName;
	private String customerEmail;
	private String customerPassword;
	
	public Customer() {
		
	}
	
	public Customer(String foreName, String lastName, String customerEmail,
			String customerPassword) {
		super();
		this.foreName = foreName;
		this.lastName = lastName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}
	
	public Customer(int customerID, String foreName) {
		super();
		this.customerID = customerID;
		this.foreName = foreName;
	}
	
	public Customer(String foreName, String lastName) {
		super();
		this.foreName = foreName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", foreName=" + foreName + ", lastName=" + lastName
				+ ", customerEmail=" + customerEmail + ", customerPassword=" + customerPassword + "]";
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerForeName() {
		return foreName;
	}

	public void setCustomerForeName(String foreName) {
		this.foreName = foreName;
	}

	public String getCustomerLastName() {
		return lastName;
	}

	public void setCustomerLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
}
