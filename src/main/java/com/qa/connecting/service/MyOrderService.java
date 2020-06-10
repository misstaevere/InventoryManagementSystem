package com.qa.connecting.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.connecting.dao.MyOrderDao;
import com.qa.connecting.exceptions.NotFoundException;
import com.qa.connecting.model.MyOrder;
import com.qa.connecting.utils.LogErrors;

public class MyOrderService {

	public static final Logger LOGGER = Logger.getLogger(MyOrderService.class);

	private MyOrderDao myOrderDao;

	public MyOrderService(MyOrderDao myOrderDao) {
		this.myOrderDao = myOrderDao;
	}

	public void create(MyOrder myOrder) {
		myOrderDao.insertMyOrder(myOrder);
	}

	public void readByID(int myOrderID) {
		try {
			List<MyOrder> orders = myOrderDao.selectMyOrderByID(new MyOrder(myOrderID));
			for (MyOrder myOrder : orders) {
				LOGGER.info(myOrder);
			}
		} catch (SQLException e) {
			new LogErrors().log(LOGGER, e);
		} catch (NotFoundException e) {
			new LogErrors().log(LOGGER, e);
		}

	}

	public void update(MyOrder myOrder) {
		try {
			myOrderDao.updateMyOrder(myOrder);
		} catch (SQLException e) {
			new LogErrors().log(LOGGER, e);
		}
	}

	public void delete(int orderID) {
		try {
			myOrderDao.deleteMyOrder(orderID);
		} catch (SQLException e) {
			new LogErrors().log(LOGGER, e);
		}
	}

}
