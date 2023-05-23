package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Entity
public class Order implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long OrderId;
	
	@Transient
	private String OrderStatus;
	
	@Transient
	private List<Meal> meals;
	
	@NotNull
	@NotEmpty
	private double total_price;
	
	@ManyToOne
	@JoinColumn(name = "resturant_id")
	private Resturant resturant;
	
	@ManyToOne
	@JoinColumn(name = "runner_id")
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
