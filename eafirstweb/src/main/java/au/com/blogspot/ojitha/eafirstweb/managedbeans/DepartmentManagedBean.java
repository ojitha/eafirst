package au.com.blogspot.ojitha.eafirstweb.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.validator.constraints.NotEmpty;

import au.com.blogspot.ojitha.eafirstejb.DepartmentService;
import au.com.blogspot.ojitha.eafirstejb.domain.Department;

@ManagedBean(name="dept")
@SessionScoped
public class DepartmentManagedBean {
	@EJB(beanName="deptService")
	DepartmentService deptService;
	
	
	@NotEmpty
	private String name;

	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	public String addDept(){
		if (this.name!=null){
			this.deptService.save(this.name);
		}
		this.name=null;
		return "";
	}


	public List<Department> getDepartments() {
		return this.deptService.getAllDepartments();
	}
	
	

}
