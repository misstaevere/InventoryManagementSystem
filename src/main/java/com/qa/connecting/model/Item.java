package com.qa.connecting.model;

public class Item {

	int itemID;
	String itemName;
	double itemPrice;

	public Item() {

	}

	public Item(int itemID, String itemName, double itemPrice) { // CONSTRUCTOR
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public Item(String itemName, double itemPrice) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public Item(int itemID) {
		this.itemID = itemID;
	}

	public Item(int itemPrice, int itemID) {
		this.itemPrice = itemPrice;
		this.itemID = itemID;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
}
