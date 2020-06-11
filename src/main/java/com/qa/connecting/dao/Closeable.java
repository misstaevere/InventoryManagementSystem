package com.qa.connecting.dao;

public interface Closeable { /* ONLY ABSTRACT METHODS, NO PRIVATE VARIABLES */

	/* public Connection connection = null; // <- public static final by default */

	public void closeConnection();

}
