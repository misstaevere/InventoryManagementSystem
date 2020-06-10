package com.qa.connecting.controller;

import org.apache.log4j.Logger;

import com.qa.connecting.model.Item;
import com.qa.connecting.service.ItemService;
import com.qa.connecting.utils.Input;

public class ItemController {

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private ItemService itemService;
	private Input input;

	public ItemController(Input input, ItemService itemService) {
		super();
		this.input = input;
		this.itemService = itemService;
	}

	public void create() {
		String itemName = getItemName();
		double itemPrice = getItemPrice();

		Item item = new Item(itemName, itemPrice);
		itemService.create(item);
	}

	public void read() {

		int itemID = getItemID();
		itemService.readByID(itemID);
	}

	public void update() {
		double itemPrice = getItemPrice();
		int itemID = getItemID();
		String itemName = getItemName();

		Item item = new Item(itemID, itemName, itemPrice);

		itemService.update(item);
	}

	public void delete() {
		int itemID = getItemID();

		itemService.delete(itemID);
	}

	private int getItemID() {
		LOGGER.info("Please enter the item ID: ");
		return Integer.parseInt(input.getInput());

	}

	private String getItemName() {
		LOGGER.info("Please enter the item name: ");
		return input.getInput();
	}

	private int getItemPrice() {
		LOGGER.info("Please enter the item price: ");
		return Integer.parseInt(input.getInput());
	}

}
