package com.qa.connecting.dao;

public interface Closeable { /* ONLY ABSTRACT METHODS, NO PRIVATE VARIABLES */

	/* public Connection connection = null; // <- public static final by default */

	public void closeConnection();

}

/*
 * // ABSTRACT EXAMPLE - CAN HAVE REAL METHODS AND ABSTRACT METHODS, VARIABLES
 * //public abstract class Connectable {
 * 
 * // private Connection connection; // // public void openConnection(); // //
 * public void closeConnection(); // // // public void sayHello() { //
 * System.out.println("Hello"); // } // //}
 */
