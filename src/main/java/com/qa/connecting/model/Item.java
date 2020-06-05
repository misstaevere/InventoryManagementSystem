package com.qa.connecting.model;

public class Item {
	
	int item_ID = 0;
	String item_name;
	int qty_ordered;
	double item_price;
	String item_category;

	public Item(int item_ID, String item_name, int qty_ordered, double item_price, String item_category) { // CONSTRUCTOR
		super();
		this.item_ID = item_ID;
		this.item_name = item_name;
		this.qty_ordered = qty_ordered;
		this.item_price = item_price;
		this.item_category = item_category;
	}

	public int getItem_ID() {
		return item_ID;
	}

	public void setItem_ID(int item_ID) {
		this.item_ID = item_ID;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getQty_ordered() {
		return qty_ordered;
	}

	public void setQty_ordered(int qty_ordered) {
		this.qty_ordered = qty_ordered;
	}

	public double getItem_price() {
		return item_price;
	}

	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}
}
