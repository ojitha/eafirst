package au.com.blogspot.ojitha.eafirstweb.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import au.com.blogspot.ojitha.eafirstejb.DepartmentService;
import au.com.blogspot.ojitha.eafirstejb.domain.Department;

@Path("dept")
public class DeptRestService {
	
	@EJB(beanName="deptService")
	DepartmentService deptService;
	
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public DeptRestService() {
        
    }

//    /**
//     * Retrieves representation of an instance of Hello
//     * @return an instance of String
//     */
//    @GET
//    @Produces("text/html")
//    public String getHtml() {
//    	return "Hello World";
//    }

    /**
     * PUT method for updating or creating an instance of Hello
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {

    }
    
    @GET
    @Path("{deptId}")
    @Produces("application/json")
    public Department getDepartment(@PathParam("deptId") Long deptId){
    	Department dept =this.deptService.findDepartmentById(deptId);
    	return dept;
    }
    @Produces("application/json")
    @GET
    public List<Department> getAllDepartements(){
    	return this.deptService.getAllDepartments();
    }
    

}