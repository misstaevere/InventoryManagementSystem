package com.qa.connecting.model;

import java.sql.Date;

public class MyOrder {

	int myOrderID;
	int fkCustomerID;
	Date myOrderPlaced;
	Double myOrderTotal;

	public MyOrder() {

	}

	public MyOrder(int myOrderID, int fkCustomerID, Date myOrderPlaced, Double myOrderTotal) { /* CONSTRUCTOR */
		super();
		this.myOrderID = myOrderID;
		this.fkCustomerID = fkCustomerID;
		this.myOrderPlaced = myOrderPlaced;
		this.myOrderTotal = myOrderTotal;

	}

	public MyOrder(int myOrderID) {
		super();
		this.myOrderID = myOrderID;
	}

	public MyOrder(int myOrderID, int fkCustomerID) {
		super();
		this.myOrderID = myOrderID;
		this.fkCustomerID = fkCustomerID;
	}

	@Override
	public String toString() {
		return "MyOrder [myOrderID=" + myOrderID + ", fkCustomerID=" + fkCustomerID + ", myOrderPlaced=" + myOrderPlaced
				+ ", myOrderTotal=" + myOrderTotal + "]";
	}

	public int getMyOrderID() {
		return myOrderID;
	}

	public void setMyOrderID(int myOrderID) {
		this.myOrderID = myOrderID;
	}

	public int getFkCustomerID() {
		return fkCustomerID;
	}

	public void setFkCustomerID(int fkCustomerID) {
		this.fkCustomerID = fkCustomerID;
	}

	public Date getMyOrderPlaced() {
		return myOrderPlaced;
	}

	public void setMyOrderPlaced(Date myOrderPlaced) {
		this.myOrderPlaced = myOrderPlaced;
	}

	public Double getMyOrderTotal() {
		return myOrderTotal;
	}

	public void setMyOrderTotal(Double myOrderTotal) {
		this.myOrderTotal = myOrderTotal;
	}
}
