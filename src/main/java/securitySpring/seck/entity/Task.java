package securitySpring.seck.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private Long id;
	private String taskname;
	public Task(Long id, String taskname) {
		super();
		this.id = id;
		this.taskname = taskname;
	}
	public Task() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	
	

}
