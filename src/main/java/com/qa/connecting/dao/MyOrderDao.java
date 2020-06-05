package com.qa.connecting.dao;

import com.qa.connecting.model.MyOrder;

public class MyOrderDao { // DATA ACCESS OBJECT - WILL BE SENDING DATA
	
	private DatabaseConnection databaseConnection;

	public MyOrderDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertMyOrder(MyOrder myOrder) { // METHOD TO ADD CUSTOMERS DATA, // STRING CATENATION
		// " " to declare int, + '' for strings = 1, 'Piers',
		String sql = "INSERT INTO my_order VALUES (" + myOrder.getMy_order_ID() + ",'"
				+ myOrder.getMy_order_placed() + "'," + myOrder.getMy_order_total() + ")";
		
			databaseConnection.sendUpdate(sql);
	
	}
}
