package com.qa.connecting.model;

import java.sql.Date;

public class MyOrder {
	
	int my_order_ID = 0;
	// int fk_customer_ID;
	Date my_order_placed;
	Double my_order_total;

	public MyOrder(int my_order_ID, Date my_order_placed, Double my_order_total) { // CONSTRUCTOR
		super();
		this.my_order_ID = my_order_ID;
		// this.fk_customer_ID = fk_customer_ID;
		this.my_order_placed = my_order_placed;
		this.my_order_total = my_order_total;
		
	}

	public int getMy_order_ID() {
		return my_order_ID;
	}

	public void setMy_order_ID(int my_order_ID) {
		this.my_order_ID = my_order_ID;
	}

	public Date getMy_order_placed() {
		return my_order_placed;
	}

	public void setMy_order_placed(Date my_order_placed) {
		this.my_order_placed = my_order_placed;
	}

	public Double getMy_order_total() {
		return my_order_total;
	}

	public void setMy_order_total(Double my_order_total) {
		this.my_order_total = my_order_total;
	}
}
