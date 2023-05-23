package model;

import java.io.Serializable;


@SuppressWarnings("serial")

public class Order implements Serializable {
	

	private long OrderId;
	

	private String OrderStatus;
	

	private List<Meal> meals;
	

	private double total_price;
	

	private Resturant resturant;

	private Runner runner;
	
	public long getOrderId() {
		return OrderId;
	}

	public void setOrderId(long orderId) {
		OrderId = orderId;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}

}
