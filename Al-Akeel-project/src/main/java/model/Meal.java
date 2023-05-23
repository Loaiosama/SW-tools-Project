package model;


import java.io.Serializable;


@SuppressWarnings("serial")

public class Meal implements Serializable{


	private long MealId;
	


	private String MealName;
	

	private double Price;


	private Resturant resturant;
	
	public long getMealId() {
		return MealId;
	}

	public void setMealId(long MealId) {
		this.MealId = MealId;
	}

	public String getMealName() {
		return MealName;
	}

	public void setMealName(String MealName) {
		this.MealName = MealName;
	}
	public double getMealPrice() {
		return Price;
	}

	public void setMealPrice(double Price) {
		this.Price = Price;
	}
	

}
