package model;


import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@SuppressWarnings("serial")
@Entity
public class Meal implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long MealId;
	

	@NotNull
    @Size(min = 1, max = 25,message="Meal name must be more than one character and less than 25")
	private String MealName;
	
	@NotNull
	@NotEmpty
	private double Price;

	@ManyToOne
	@JoinColumn(name = "resturant_id")
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
