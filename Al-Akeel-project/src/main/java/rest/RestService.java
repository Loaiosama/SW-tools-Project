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

import model.User;


@Path("/signup")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestService {
	
	@PersistenceContext
    EntityManager manager;
	
	@POST
	@Path("/post")
	 public Response signup(User user) {

 		String name = user.getName();
 		String role = user.getRole();
 		String pass = user.getPassword();
         // create new user
         User newUser = new User();
         newUser.setName(name);
         newUser.setRole(role);
         newUser.setPassword(pass);

         manager.persist(newUser);

//         return Response.status(Response.Status.CREATED).build();
         return Response.ok().entity("sign up done "  ).build() ;
     } 
	
	
//	@POST
//	@Path("/sign")
//	public String authenticateUser(String name, String password,String role) {
//		User user = new User();
//		user.getName();
//		user.getRole();
//		user.getPassword();
//		TypedQuery<User> query = manager.createQuery("SELECT u FROM User u WHERE u.name = :name AND u.password = :password AND u.role = :role", User.class);
//		query.setParameter("name", name);
//		query.setParameter("password", password);
//		query.setParameter("role", role);
//		if (query.getSingleResult()!=null) {
//			return "yes";
//		}
//		else {
//			return "no";
//		}
//	}
	
	


	@GET
	@Path("User")
	public List<User> getResult() {
		TypedQuery<User> query = manager.createQuery("SELECT m FROM User m", User.class);
//		List <calculation1> l = manager.createQuery("SELECT operation FROM calculation operation" , calculation1.class).getResultList();
		List<User> l = query.getResultList();
//		return Response.ok().entity(l).build();
		return l;
		
	}

}
