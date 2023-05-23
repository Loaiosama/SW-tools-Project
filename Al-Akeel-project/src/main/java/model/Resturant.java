package model;

import java.io.Serializable;


@SuppressWarnings("serial")

public class Resturant implements Serializable{
	

	private long Id;
	

	private String name;


	private List<Meal> meals;
	

	private List<Runner> runners;

	private List<Order> orders;

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
}
