package com.qa.connecting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.connecting.exceptions.NotFoundException;
import com.qa.connecting.model.Item;

public class ItemDao { // DATA ACCESS OBJECT - WILL BE SENDING DATA

	private DatabaseConnection databaseConnection;

	public static final Logger LOGGER = Logger.getLogger(ItemDao.class);

	public ItemDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertItem(Item item) { // METHOD TO ADD CUSTOMERS DATA, // STRING
		// CATENATION
		String sql = "INSERT INTO item (item_name, item_price) VALUES ('" + item.getItemName() + "',"
				+ item.getItemPrice() + ")";

		databaseConnection.sendUpdate(sql);
		LOGGER.info("New item was successfully added!");

	}

	public List<Item> selectItemByID(Item item) throws SQLException {
		String sql = "SELECT * FROM item WHERE item_ID = (" + item.getItemID() + ")";
		ResultSet rs = databaseConnection.sendQuery(sql);
		List<Item> items = new ArrayList<Item>();
		if (rs.next()) {
			rs.beforeFirst();
			while (rs.next()) {
				Item temp = new Item();
				temp.setItemID(rs.getInt("item_ID"));
				temp.setItemName(rs.getString("item_name"));
				temp.setItemPrice(rs.getDouble("item_price"));

				items.add(temp);
			}
		} else {
			throw new NotFoundException("Item not found");
		}

		return items;

	}

	public void updateItem(Item item) throws SQLException {
		String sql = "UPDATE item SET item_price=? WHERE item_ID=?";

		PreparedStatement statement = databaseConnection.getPreparedStatement(sql);
		statement.setDouble(1, item.getItemPrice());
		statement.setLong(2, item.getItemID());

		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
			LOGGER.info("An existing item was updated successfully!");
		}

	}

	public void deleteItem(int itemID) throws SQLException {

		String sql = "DELETE FROM item WHERE item_ID=?";

		PreparedStatement statement = databaseConnection.getPreparedStatement(sql);
		statement.setInt(1, itemID);

		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
			LOGGER.info("An item was deleted successfully!");
		}
	}

}
