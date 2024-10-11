package securitySpring.seck.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class AppUser {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true)
	private String username;
	private String password;
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> appRoles = new ArrayList<>();

	public AppUser(Long id, String username, String password, Collection<AppRole> appRoles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.appRoles = appRoles;
	}
	

	public AppUser(String username, String password, Collection<AppRole> appRoles) {
		super();
		this.username = username;
		this.password = password;
		this.appRoles = appRoles;
	}


	public AppUser() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<AppRole> getAppRoles() {
		return appRoles;
	}

	public void setAppRoles(Collection<AppRole> appRoles) {
		this.appRoles = appRoles;
	}
	

}
