package au.com.blogspot.ojitha.eafirstejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import au.com.blogspot.ojitha.eafirstejb.domain.Department;

/**
 * Session Bean implementation class DepartmentService
 */
@Stateless(name="deptService")
@LocalBean
public class DepartmentService {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public DepartmentService() {

    }
    
    public void save(String name){
    	Department dept = new Department();
    	dept.setName(name);
    	em.persist(dept);
    }

}
