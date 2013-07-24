package au.com.blogspot.ojitha.eafirstweb.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import au.com.blogspot.ojitha.eafirstejb.DepartmentService;

@ManagedBean(name="dept")
@SessionScoped
public class DepartmentManagedBean {
	@EJB(beanName="deptService")
	DepartmentService deptService;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String addDept(){
		this.deptService.save(this.name);
		return "/response.xhtml";
	}

}
