package com.qa.connecting;

import org.apache.log4j.Logger;

import com.qa.connecting.dao.RemoteDatabaseConnection;
import com.qa.connecting.utils.Input;

// LOskMaK1bhhFpvsF

public class Main {
	
	public static final Logger LOGGER = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		Input input = new Input();
		LOGGER.info("Database username: ");
		String user = input.getInput();
		LOGGER.info("Database password: ");
		String password = input.getInput();

		RemoteDatabaseConnection connection = new RemoteDatabaseConnection(user, password);

		Ims ims = new Ims(input, connection);
		ims.start(); 
		connection.closeConnection();

	}
		
}
