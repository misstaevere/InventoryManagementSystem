package com.qa.connecting.controller;

import org.apache.log4j.Logger;

import com.qa.connecting.model.MyOrder;
import com.qa.connecting.service.MyOrderService;
import com.qa.connecting.utils.Input;

public class MyOrderController {
	
public static final Logger LOGGER = Logger.getLogger(MyOrderController.class);
	
	private MyOrderService myOrderService;
	private Input input;
	
	public MyOrderController(Input input, MyOrderService myOrderService) {
		super();
		this.input = input;
		this.myOrderService = myOrderService;
	}

	public void create() {
		int customerID = getFkCustomerIDFromUser();

		MyOrder myOrder = new MyOrder(0, customerID);
		myOrderService.create(myOrder);
	}

	public void read() {

		int orderID = getOrderIDFromUser();
		myOrderService.readByID(orderID);
	}

	public void update() {
		int orderID = getOrderIDFromUser();
		int cid = getFkCustomerIDFromUser();

		MyOrder myOrder= new MyOrder(cid, orderID);

		myOrderService.update(myOrder);
	}

	public void delete() {
		int orderID = getOrderIDFromUser();
		
		myOrderService.delete(orderID);
	}
	
	private int getOrderIDFromUser() {
		LOGGER.info("Please enter the order ID: ");
		return Integer.parseInt(input.getInput());

	}
	
	private int getFkCustomerIDFromUser() {
		LOGGER.info("Please enter the customer ID: ");
		return Integer.parseInt(input.getInput());
	}


}
