package au.com.blogspot.ojitha.eafirstejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public Department findDepartmentById(Long id){
    	Query query =em.createNamedQuery("findDeptById");
    	query.setParameter("deptId", id);
    	Department dept = (Department)query.getResultList().get(0);
    	return dept;
    }
    
    public List<Department> getAllDepartments(){
    	Query query = em.createNamedQuery("getAllDepts");
    	return query.getResultList();
    }

}
