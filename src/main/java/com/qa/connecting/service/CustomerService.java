package com.qa.connecting.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.connecting.dao.CustomerDao;
import com.qa.connecting.exceptions.NotFoundException;
import com.qa.connecting.model.Customer;
import com.qa.connecting.utils.LogErrors;

public class CustomerService {

	public static final Logger LOGGER = Logger.getLogger(CustomerService.class);

	private CustomerDao customerDao;

	public CustomerService(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void create(Customer customer) {
		customerDao.insertCustomer(customer);
	}

	public void readByName(String firstName, String lastName) {
		try {
			List<Customer> customers = customerDao.selectCustomerByName(new Customer(firstName, lastName));
			for(Customer customer: customers) {
				LOGGER.info(customer);
			}
		} catch (SQLException e) {
			new LogErrors().log(LOGGER, e);
		} catch (NotFoundException e) {
			new LogErrors().log(LOGGER, e);
		}
		
	}

	public void update(Customer customer) {
		try {
			customerDao.updateCustomerName(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new LogErrors().log(LOGGER, e);
		}
	}

	public void delete(String firstName) {
		try {
			customerDao.deleteCustomer(firstName);
		} catch (SQLException e) {
			new LogErrors().log(LOGGER, e);
		}
	}

}
