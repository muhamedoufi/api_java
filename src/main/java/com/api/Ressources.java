package com.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



import com.api.dao.EmployeeDAO;
import com.api.entity.Employee;
import java.util.List;



import jakarta.inject.Inject;
//import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.PathParam;


@Path("myresource")
public class Ressources {
//	@Inject
	

//	   @GET
//	    @Produces(MediaType.APPLICATION_JSON)
//	    public List<Employee> getAll(){
//	    	Dao dao = new EmployeeDAO();
//        	
////        	.forEach(u -> System.out.println(u));
//
//
//	    	return  dao.getAllEmployees();
//	    }
	    @GET
	    @Path("/all")
	    @Produces("application/json")
	    public List<Employee> getEmployee() {
	      EmployeeDAO dao = new EmployeeDAO();
	      List employees = dao.getAllEmployees();
	        return employees;
	    }
	    
	    @GET
	    @Path("/get/{id}")
	    @Produces("application/json")
	    public Employee getEmployeeById(@PathParam("id") int id) {
	      EmployeeDAO dao = new EmployeeDAO();
	      Employee employee = dao.getEmployeeById(id);
	        return employee;
	    }

	
	    @POST
	    @Path("/create")
	    @Consumes("application/json")
	    
	    
//	    Exemple for test this endpoint in postman
//	    {
//	    	"name":"Ahmed",
//	    	 "age":19
//	    }
	    public Response addEmployee(Employee emp){
	    emp.setName(emp.getName());
	    emp.setAge(emp.getAge());
	            
	    EmployeeDAO dao = new EmployeeDAO();
	    dao.saveEmployee(emp);
	    
	    return Response.ok().build();
	    }
	    
	    @PUT
	    @Path("/update/{id}")
	    @Consumes("application/json")
	    public Response updateEmployee(@PathParam("id") int id, Employee emp){
	      EmployeeDAO dao = new EmployeeDAO();
	    int count = dao.updateEmployee(id, emp);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("l'operation a reussite").build();
	    }
	    
	    
	    @DELETE
	    @Path("/delete/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response deleteEmployee(@PathParam("id") int id){
	      EmployeeDAO dao = new EmployeeDAO();
	    int count = dao.deleteEmployeeById(id);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("Rows affected: "+count).build();
	    }
}
