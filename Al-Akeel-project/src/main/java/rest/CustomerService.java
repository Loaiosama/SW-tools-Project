package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Meal;
import model.User;
import model.Order;
import model.Resturant;
import Enums.OrderStatus;
import javax.ws.rs.PathParam;


@Path("/customer")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerService {
	@PersistenceContext
    EntityManager manager;
	
	@POST
	public void createOrder(Order order,Meal meal) {
		String mealName = meal.getMealName();
		double mealPrice = meal.getMealPrice();
		OrderStatus status= new OrderStatus();
		Meal newMeal = new Meal();
		meal.setMealName(mealName);
		meal.setMealPrice(mealPrice);
		order.addMeal(newMeal);
//		order.setOrderStatus(status);
		
		manager.persist(newMeal);
		double price = order.getTotal_price();
		Order newOrder = new Order();
		newOrder.getOrderStatus();
		newOrder.setTotal_price(price);
		manager.persist(newOrder);
	}
	
	@GET
	@Path("/getresturant")
	public List<Resturant> getResturant() {
		TypedQuery<Resturant> query = manager.createQuery("SELECT m FROM Resturant m", Resturant.class);
		List<Resturant> l = query.getResultList();
//		return Response.ok().entity(l).build();
		return l;
	}
	
	@POST
	@Path("/{customerid}/{resturantid}/createorder")	
	public Order createOrder(@PathParam("customerid")Long customerId, @PathParam("resturantid")Long restaurantId) {
		
        User customer = manager.find(User.class, customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found with id: " + customerId);
        }

        Resturant resturant = manager.find(Resturant.class, restaurantId);
        if (resturant == null) {
            throw new IllegalArgumentException("Restaurant not found with id: " + restaurantId);
        }

        Order order = new Order();
        Meal meal = new Meal();
        meal.getMealName();
        meal.getMealPrice();
        order.addMeal(meal);

        manager.persist(order);

        return order;
	    
	    
	   
	}
}
	    
	
