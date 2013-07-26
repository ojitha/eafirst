package au.com.blogspot.ojitha.eafirstejb.domain;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Department
 *
 */
@NamedQueries({
	@NamedQuery(name="findDeptById", query="SELECT d from Department d where d.deptId = :deptId"),
	@NamedQuery(name="getAllDepts", query="SELECT d from Department d")
})
@Entity

public class Department implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long deptId;
	private String name;
	private static final long serialVersionUID = 1L;

	public Department() {
		super();
	}   
	public Long getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
