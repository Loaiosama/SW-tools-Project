package model;

import java.io.Serializable;
//import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")

public class Runner implements Serializable {
	

	private long Id;
	
	

	private String name;
	

	private String status;
	

	private double delivery_fees;


	private Resturant resturant;
	

	private Set<Order> order;
	
	
	public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDelivery_fees() {
		return delivery_fees;
	}

	public void setDelivery_fees(double delivery_fees) {
		this.delivery_fees = delivery_fees;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
