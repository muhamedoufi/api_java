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
import com.api.dao.EtudiantDao;
import com.api.dao.MatiereDao;
import com.api.entity.Employee;
import com.api.entity.Etudiant;
import com.api.entity.Filiere;
import com.api.entity.Matiere;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



import jakarta.inject.Inject;
//import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.PathParam;


@Path("myresource")
public class Ressources {
	

	    @GET
	    @Path("/employee/all")
	    @Produces("application/json")
	    public List<Employee> getEmployee() {
	      EmployeeDAO dao = new EmployeeDAO();
	      List employees = dao.getAll();
	        return employees;
	    }
	    
	    @GET
	    @Path("/employee/get/{id}")
	    @Produces("application/json")
	    public Employee getEmployeeById(@PathParam("id") int id) {
	      EmployeeDAO dao = new EmployeeDAO();
	      Employee employee = dao.getById(id);
	        return employee;
	    }

	
	    @POST
	    @Path("/employee/create")
	    @Consumes("application/json")
	    
	    
//	    Exemple for test this endpoint in postman
//	    {
//	    	"name":"Ahmed",
//	    	 "age":19
//	    }
	    public Response addEmployee(Employee emp){
//	    emp.setName(emp.getName());
//	    emp.setAge(emp.getAge());
	            
	    EmployeeDAO dao = new EmployeeDAO();
	    dao.save(emp);
	    
	    return Response.ok().build();
	    }
	    
	    @PUT
	    @Path("/employee/update/{id}")
	    @Consumes("application/json")
	    public Response updateEmployee(@PathParam("id") int id, Employee emp){
	      EmployeeDAO dao = new EmployeeDAO();
	    int count = dao.update(id, emp);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("l'operation a reussite").build();
	    }
	    
	    
	    @DELETE
	    @Path("/employee/delete/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response deleteEmployee(@PathParam("id") int id){
	      EmployeeDAO dao = new EmployeeDAO();
	    int count = dao.deleteById(id);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("Rows affected: "+count).build();
	    }
	    
	    
	    
	    @GET
	    @Path("/etudiant/all")
	    @Produces("application/json")
	    public List<Etudiant> getEtudiants() {
	      EtudiantDao dao = new EtudiantDao();
	      List etudi = dao.getAll();
	        return etudi;
	    }
	    
	    @GET
	    @Path("/etudiant/get/{id}")
	    @Produces("application/json")
	    public Etudiant getEtudiantById(@PathParam("id") int id) {
	      EtudiantDao dao = new EtudiantDao();
	      Etudiant etud = dao.getById(id);
	        return etud;
	    }

	
	    @POST
	    @Path("/etudiant/create")
	    @Consumes("application/json")

	    public Response addEtudiant(Etudiant etud) {
//	        Filiere filiere = Filiere.valueOf(etud.getFiliere());

//	        switch(etud.getFiliere()) {
//	            case "BIOLOGIE":
//	                etud.setFiliere(Filiere.BIOLOGIE);
//	                break;
//	            case "INFORMATIQUE":
//	                etud.setFiliere(Filiere.INFORMATIQUE);
//	                break;
//	            case "PHYSIQUE":
//	                etud.setFiliere(Filiere.PHYSIQUE);
//	                break;
//	            case "MATHEMATIQUE":
//	                etud.setFiliere(Filiere.MATHEMATIQUE);
//	                break;
//	            default:
//	                // handle invalid value or throw an exception
//	                break;
//	        }
	        
	        EtudiantDao dao = new EtudiantDao();
	        dao.save(etud);
	        
	        return Response.ok().build();
	    }
	    
	    @PUT
	    @Path("/etudiant/update/{id}")
	    @Consumes("application/json")
	    public Response updateEtudiant(@PathParam("id") int id, Etudiant etud){
	      EtudiantDao dao = new EtudiantDao();
	    int count = dao.update(id, etud);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("l'operation a reussite").build();
	    }
	    
	    
	    @DELETE
	    @Path("/etudiant/delete/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response deleteEtudiant(@PathParam("id") int id){
	      EtudiantDao dao = new EtudiantDao();
	    int count = dao.deleteById(id);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("Rows affected: "+count).build();
	    }
	    
	    
	    
//	    MAtierererere
	    
	    
	    
	    @GET
	    @Path("/matiere/all")
	    @Produces("application/json")
	    public List<Matiere> getMatieres() {
	      MatiereDao dao = new MatiereDao();
	      List matieres = dao.getAll();
	        return matieres;
	    }
	    
	    @GET
	    @Path("/matiere/get/{id}")
	    @Produces("application/json")
	    public Matiere getMatiereById(@PathParam("id") int id) {
	      MatiereDao dao = new MatiereDao();
	      Matiere matiere = dao.getById(id);
	        return matiere;
	    }

	
	    @POST
	    @Path("/matiere/create")
	    @Consumes("application/json")

	    public Response addMatiere(Matiere matiere) {

	        
	        MatiereDao dao = new MatiereDao();
	        dao.save(matiere);
	        
	        return Response.ok().build();
	    }
	    
	    @PUT
	    @Path("/matiere/update/{id}")
	    @Consumes("application/json")
	    public Response updateMatiere(@PathParam("id") int id, Matiere matiere){
	      MatiereDao dao = new MatiereDao();
	    int count = dao.update(id, matiere);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("l'operation a reussite").build();
	    }
	    
	    
	    @DELETE
	    @Path("/matiere/delete/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response deleteMatiere(@PathParam("id") int id){
	    	MatiereDao dao = new MatiereDao();
	    int count = dao.deleteById(id);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("Rows affected: "+count).build();
	    }
	    
	    
	    
//	   note 
	    
	    
	    @POST
	    @Path("/note/create")
	    @Consumes("application/json")

	    public Response addNote(JsonNode obj){
	    	EtudiantDao etuddao = new EtudiantDao();
	    	MatiereDao matDao = new MatiereDao();
	    	
	        String note = obj.get("note").asText();
	    	String matiereid = obj.get("matiere").asText();
	    	System.out.print(note+matiereid);
	    	String etudid = obj.get("etudiant").asText();
	    	Etudiant e = etuddao.getById(Long.parseLong(etudid));
	    	Matiere mat = matDao.getById(Long.parseLong(matiereid));

	    	Collection<Etudiant> etudia = mat.getEtudiants();
	    	Collection<Matiere> matieres = e.getMatieres();

	        etudia.add(e);
	        matieres.add(mat);
	        mat.setNote(Double.parseDouble(note));
	        mat.setEtudiants(etudia);
	        e.setMatieres(matieres);
	        etuddao.update(Integer.parseInt(etudid), e);
	        matDao.update(Integer.parseInt(matiereid),mat);

	    
	    return Response.ok().build();
	    }
	    
}
