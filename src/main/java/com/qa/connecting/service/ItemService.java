package com.qa.connecting.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.connecting.dao.ItemDao;
import com.qa.connecting.exceptions.NotFoundException;
import com.qa.connecting.model.Item;
import com.qa.connecting.utils.LogErrors;

public class ItemService {
	
	public static final Logger LOGGER = Logger.getLogger(ItemService.class);

	private ItemDao itemDao;

	public ItemService(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void create(Item item) {
		itemDao.insertItem(item);
	}

	public void readByID(int itemID) {
		try {
			List<Item> items = itemDao.selectItemByID(new Item(itemID));
			for (Item item : items) {
				LOGGER.info(item);
			}
		} catch (SQLException | NotFoundException e) {
			new LogErrors().log(LOGGER, e);
		} 

	}

	public void update(Item item) {
		try {
			itemDao.updateItem(item);
		} catch (SQLException e) {
			new LogErrors().log(LOGGER, e);
		}
	}

	public void delete(int itemID) {
		try {
			itemDao.deleteItem(itemID);
		} catch (SQLException e) {
			new LogErrors().log(LOGGER, e);
		}
	}


}
