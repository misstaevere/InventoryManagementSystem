package com.qa.connecting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.connecting.exceptions.NotFoundException;
import com.qa.connecting.model.MyOrder;

public class MyOrderDao { // DATA ACCESS OBJECT - WILL BE SENDING DATA

	private DatabaseConnection databaseConnection;

	public static final Logger LOGGER = Logger.getLogger(MyOrderDao.class);

	public MyOrderDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertMyOrder(MyOrder myOrder) { // METHOD TO ADD CUSTOMERS DATA, // STRING CATENATION
		String sql = "INSERT INTO my_order (fk_customer_ID) VALUES (" + myOrder.getFkCustomerID() + ")";

		databaseConnection.sendUpdate(sql);
		LOGGER.info("New order was successfully created!");
	}

	public List<MyOrder> selectMyOrderByID(MyOrder myOrder) throws SQLException {
		String sql = "SELECT * FROM my_order WHERE my_order_ID = (" + myOrder.getMyOrderID() + ")";
		ResultSet rs = databaseConnection.sendQuery(sql);
		List<MyOrder> orders = new ArrayList<MyOrder>();
		if (rs.next()) {
			rs.beforeFirst();
			while (rs.next()) {
				MyOrder temp = new MyOrder();
				temp.setMyOrderID(rs.getInt("my_order_ID"));
				temp.setFkCustomerID(rs.getInt("fk_customer_ID"));
				temp.setMyOrderPlaced(rs.getDate("my_order_placed"));

				orders.add(temp);
			}
		} else {
			throw new NotFoundException("Order not found");
		}

		return orders;

	}

	public void updateMyOrder(MyOrder myOrder) throws SQLException {
		String sql = "UPDATE my_order SET my_order_ID=? WHERE fk_customer_ID=?";

		PreparedStatement statement = databaseConnection.getPreparedStatement(sql);
		statement.setLong(1, myOrder.getMyOrderID());
		statement.setLong(2, myOrder.getFkCustomerID());

		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
			LOGGER.info("An existing order was updated successfully!");
		}

	}

	public void deleteMyOrder(int orderID) throws SQLException {

		String sql = "DELETE FROM my_order WHERE my_order_ID=?";

		PreparedStatement statement = databaseConnection.getPreparedStatement(sql);
		statement.setInt(1, orderID);

		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
			LOGGER.info("An order was deleted successfully!");
		}
	}

}
