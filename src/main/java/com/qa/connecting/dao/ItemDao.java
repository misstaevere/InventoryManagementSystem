package com.qa.connecting.dao;

import com.qa.connecting.model.Item;

public class ItemDao { // DATA ACCESS OBJECT - WILL BE SENDING DATA
	
	private DatabaseConnection databaseConnection;

	public ItemDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertItem(Item item) { // METHOD TO ADD CUSTOMERS DATA, // STRING CATENATION
		// " " to declare int, + '' for strings = 1, 'Piers',
		String sql = "INSERT INTO item VALUES (" + item.getItem_ID() + ",'"
				+ item.getItem_name() + "'," + item.getQty_ordered() + ","
				+ item.getItem_price() + ",'" + item.getItem_category() + "')";
		
			databaseConnection.sendUpdate(sql);
	}
}

