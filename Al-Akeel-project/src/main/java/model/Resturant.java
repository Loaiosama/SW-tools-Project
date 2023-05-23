package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
public class Resturant implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	private long Id;
	
	@NotNull
	@Size(min = 1, max = 25)
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "resturant")
	private List<Meal> meals;
	
	@OneToMany(mappedBy = "resturant")
	private List<Runner> runners;
	
	@OneToMany(mappedBy = "resturant")
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
