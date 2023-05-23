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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Meal;
import model.Resturant;
import model.User;
import model.Meal;
import model.Order;

@Stateless
@Path("/owner")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResturantOwnerService {
	@PersistenceContext
    EntityManager manager;
	
	@POST
	public void createResturant(Resturant resturant) {
//		name = "mac";
//		Resturant resturant = new Resturant();
//		resturant.setName(name);
		String name = resturant.getName();
		Resturant newRest = new Resturant();
		newRest.setName(name);
		manager.persist(newRest);
	}
	
	@POST
	@Path("/{restruantId}/createmenu")
	public String CreateMenu(@PathParam("resturantId") int id , Meal meal) {
		
        Resturant resturant = manager.find(Resturant.class, id);
        
		String mealName = meal.getMealName();
		double mealPrice = meal.getMealPrice();
		Meal newMeal = new Meal();
		meal.setMealName(mealName);
		meal.setMealPrice(mealPrice);
//		Resturant resturant = new Resturant();
		resturant.addMeal(newMeal);
		manager.persist(newMeal);
		manager.merge(resturant);
		
		return "done";
//		
	}
	
	
	@GET
	@Path("/getresturant")
	public List<Resturant> getResturant() {
		TypedQuery<Resturant> query = manager.createQuery("SELECT m FROM Resturant m", Resturant.class);
//		List <calculation1> l = manager.createQuery("SELECT operation FROM calculation operation" , calculation1.class).getResultList();
		List<Resturant> l = query.getResultList();
//		return Response.ok().entity(l).build();
		return l;
		
		
	}
	@GET
	@Path("/{restid}/getdetails")
	public void getDetails(@PathParam("restid") int id) {
	    try {
	        Resturant resturant = manager.find(Resturant.class, id);
	        TypedQuery<Resturant> query = manager.createQuery("SELECT r FROM Restaurant r WHERE r.id = :id", Resturant.class);
	        query.setParameter("id", id);
	        resturant = query.getSingleResult();
	        if (resturant != null) {
	            System.out.println("Name: " + resturant.getName());
//	            System.out.println("Meals: " + resturant.getMeal());
	        } else {
	            System.out.println("Restaurant not found.");
	        }
	    } catch (Exception e) {
	        System.out.println("Error retrieving restaurant details: " + e.getMessage());
	    }
	}
	
	@GET
	@Path("/report")
	public void createreport() {
		TypedQuery<Order> query = manager.createQuery("SELECT SUM(r.totalAmount) FROM Order r ", Order.class);
		System.out.println("Report" + query);
	}
	
	
//	@POST
//	@Path("/menu")
//	public Response resturantOwner(List<Meal> resturantMeals){
//		
//		return null;
//		
//	}
}
