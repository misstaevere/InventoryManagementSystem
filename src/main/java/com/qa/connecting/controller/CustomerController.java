package com.qa.connecting.controller;

import org.apache.log4j.Logger;

import com.qa.connecting.model.Customer;
import com.qa.connecting.service.CustomerService;
import com.qa.connecting.utils.Input;

public class CustomerController {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	private CustomerService customerService;
	private Input input;
	
	public CustomerController(Input input, CustomerService customerService) {
		super();
		this.input = input;
		this.customerService = customerService;
	}

	public void create() {
		String firstName = getFirstNameFromUser();

		LOGGER.info("Customer last name: ");
		String lastName = input.getInput();

		LOGGER.info("Customer email: ");
		String email = input.getInput();

		LOGGER.info("Customer password: ");
		String customerPassword = input.getInput();

		Customer customer = new Customer(firstName, lastName, email, customerPassword);
		customerService.create(customer);
	}

	public void read() {

		String firstName = getFirstNameFromUser();
		LOGGER.info("Customer last name: ");
		String lastName = input.getInput();

		customerService.readByName(firstName, lastName);
	}

	public void update() {
		String firstName = getFirstNameFromUser();

		LOGGER.info("Customer ID: ");
		int cid = Integer.parseInt(input.getInput());

		Customer customer= new Customer(cid, firstName);

		customerService.update(customer);
	}

	public void delete() {
		String firstName = getFirstNameFromUser();
		customerService.delete(firstName);
	}
	
	private String getFirstNameFromUser() {
		LOGGER.info("Customer first name: ");
		return input.getInput();

	}

}
