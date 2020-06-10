package com.qa.connecting.model;

public class Orderline {

	int orderlineID = 0;
	int fkMyOrderID;
	int fkItemID;
	int qtyOrdered;

	public Orderline(int orderlineID, int fkMyOrderID, int fkItemID, int qtyOrdered) {
		super();
		this.orderlineID = orderlineID;
		this.fkMyOrderID = fkMyOrderID;
		this.fkItemID = fkItemID;
		this.qtyOrdered = qtyOrdered;
	}

	public int getOrderlineID() {
		return orderlineID;
	}

	public void setOrderlineID(int orderlineID) {
		this.orderlineID = orderlineID;
	}

	public int getFkMyOrderID() {
		return fkMyOrderID;
	}

	public void setFkMyOrderID(int fkMyOrderID) {
		this.fkMyOrderID = fkMyOrderID;
	}

	public int getFkItemID() {
		return fkItemID;
	}

	public void setFkItemID(int fkItemID) {
		this.fkItemID = fkItemID;
	}

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
}
