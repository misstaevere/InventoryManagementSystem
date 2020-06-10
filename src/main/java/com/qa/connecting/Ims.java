package com.qa.connecting;

import org.apache.log4j.Logger;

import com.qa.connecting.controller.CustomerController;
import com.qa.connecting.controller.ItemController;
import com.qa.connecting.controller.MyOrderController;
import com.qa.connecting.dao.CustomerDao;
import com.qa.connecting.dao.DatabaseConnection;
import com.qa.connecting.dao.ItemDao;
import com.qa.connecting.dao.MyOrderDao;
import com.qa.connecting.service.CustomerService;
import com.qa.connecting.service.ItemService;
import com.qa.connecting.service.MyOrderService;
import com.qa.connecting.utils.Input;

public class Ims {

	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	private Input input = new Input();
	private DatabaseConnection connection;

	public Ims(Input input, DatabaseConnection connection) {
		super();
		this.input = input;
		this.connection = connection;
	}

	public void start() {

		/*
		 * LOGGER.trace("Trace"); LOGGER.debug("Debugging"); LOGGER.info("FYI");
		 * LOGGER.warn("I'm warning you"); LOGGER.error("Does not compute");
		 * LOGGER.fatal("RIP");
		 */

		/*
		 * // Below needs to be similar to Garage project // where different type of
		 * objects can be built and different inputs are // required //
		 * --------------------------
		 */

		LOGGER.info("What would you like to do? Choose from the following: "); /* Insert, Read, Update, Delete, Exit */

		for (Action action : Action.values()) {
			LOGGER.info(action.name());
		}

		Action selectedAction;

		while (true) {
			try {
				String actionInput = input.getInput();
				selectedAction = Action.valueOf(actionInput.toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.warn("Not a valid option, try again!");
			}
		}

		for (Tables tables : Tables.values()) {
			LOGGER.info(tables.name());
		}

		Tables selectedTables;

		while (true) {
			try {
				String tablesInput = input.getInput();
				selectedTables = Tables.valueOf(tablesInput.toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.warn("Not a valid option, try again!");
			}
		}

		switch (selectedTables) {
		case CUSTOMER:
			customerChoice(selectedAction);
			break;
		case ITEM:
			itemChoice(selectedAction);
			break;
		case ORDER:
			orderChoice(selectedAction);
			break;
		case RESTART:
			break;
		case EXIT:
			System.exit(0);
			break;
		default:
			break;
		}
	}

	public void customerChoice(Action action) {
		CustomerController controller = new CustomerController(input, new CustomerService(new CustomerDao(connection)));
		switch (action) {
		case INSERT:
			controller.create();
			break;
		case READ:
			controller.read();
			break;
		case UPDATE:
			controller.update();
			break;
		case DELETE:
			controller.delete();
			break;
		case EXIT:
			System.exit(0);
			break;
		default:
			break;
		}
	}

	public void orderChoice(Action action) {
		MyOrderController controller = new MyOrderController(input, new MyOrderService(new MyOrderDao(connection)));
		switch (action) {
		case INSERT:
			controller.create();
			break;
		case READ:
			controller.read();
			break;
		case UPDATE:
			controller.update();
			break;
		case DELETE:
			controller.delete();
			break;
		case EXIT:
			System.exit(0);
			break;
		default:
			break;
		}
	}

	public void itemChoice(Action action) {
		ItemController controller = new ItemController(input, new ItemService(new ItemDao(connection)));
		switch (action) {
		case INSERT:
			controller.create();
			break;
		case READ:
			controller.read();
			break;
		case UPDATE:
			controller.update();
			break;
		case DELETE:
			controller.delete();
			break;
		case EXIT:
			System.exit(0);
			break;
		default:
			break;
		}
	}
}
