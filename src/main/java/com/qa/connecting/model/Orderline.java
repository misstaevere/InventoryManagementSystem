package com.qa.connecting.model;

public class Orderline {

	int orderline_ID = 0;
	int fk_my_order_ID;
	int fk_item_ID;
	int qty_ordered;

	public Orderline(int orderline_ID, int fk_my_order_ID, int fk_item_ID, int qty_ordered) {
		super();
		this.orderline_ID = orderline_ID;
		this.fk_my_order_ID = fk_my_order_ID;
		this.fk_item_ID = fk_item_ID;
		this.qty_ordered = qty_ordered;
	}

	public int getOrderline_ID() {
		return orderline_ID;
	}

	public void setOrderline_ID(int orderline_ID) {
		this.orderline_ID = orderline_ID;
	}

	public int getFk_my_order_ID() {
		return fk_my_order_ID;
	}

	public void setFk_my_order_ID(int fk_my_order_ID) {
		this.fk_my_order_ID = fk_my_order_ID;
	}

	public int getFk_item_ID() {
		return fk_item_ID;
	}

	public void setFk_item_ID(int fk_item_ID) {
		this.fk_item_ID = fk_item_ID;
	}

	public int getQty_ordered() {
		return qty_ordered;
	}

	public void setQty_ordered(int qty_ordered) {
		this.qty_ordered = qty_ordered;
	}
}
