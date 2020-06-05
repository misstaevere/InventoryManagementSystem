package com.qa.connecting.dao;

import com.qa.connecting.model.Orderline;

public class OrderlineDao {
	
	private DatabaseConnection databaseConnection;

	public OrderlineDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertOrderline(Orderline orderline) { // METHOD TO ADD CUSTOMERS DATA, // STRING CATENATION
		// " " to declare int, + '' for strings = 1, 'Piers',
		String sql = "INSERT INTO orderline VALUES (" + orderline.getOrderline_ID() + ","
				+ orderline.getFk_my_order_ID() + "," + orderline.getFk_item_ID() + ","
				+ orderline.getQty_ordered() + ")";
		
			databaseConnection.sendUpdate(sql);
	}

}
