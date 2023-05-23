package model;

import java.io.Serializable;
//import java.util.List;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Entity
public class Runner implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long Id;
	
	
	@NotNull
    @Size(min = 1, max = 25)
	private String name;
	
	@Transient
	private String status;
	
	@NotNull
	@NotEmpty
	private double delivery_fees;

	@ManyToOne
	@JoinColumn(name="resturant_id")
	private Resturant resturant;
	
	@OneToMany(mappedBy = "runner")
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
