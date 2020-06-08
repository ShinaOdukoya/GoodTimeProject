package com.goodTime.model;


public class OrderProduct {
	
	private Drink drink;
	private Order order;
	private int quantity;
	private double totalPrice;
	
	
	public OrderProduct() {
		
	}
	
	public OrderProduct(Drink drink, int quantity) {
		this.drink = drink;
		this.quantity = quantity;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
