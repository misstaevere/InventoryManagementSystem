package com.qa.connecting.dao;

import com.qa.connecting.model.Orderline;

public class OrderlineDao {
	
	private DatabaseConnection databaseConnection;

	public OrderlineDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertOrderline(Orderline orderline) { // METHOD TO ADD CUSTOMERS DATA, // STRING CATENATION
		// " " to declare int, + '' for strings = 1, 'Piers',
		String sql = "INSERT INTO orderline (fk_my_order_ID, fk_item_ID) VALUES (" +
				+ orderline.getFk_my_order_ID() + "," + orderline.getFk_item_ID() + ")";
		
			databaseConnection.sendUpdate(sql);
	}

}
