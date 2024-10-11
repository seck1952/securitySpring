package securitySpring.seck.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RegisterForm {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private String repassword;

	public RegisterForm(Long id, String username, String password, String repassword) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.repassword = repassword;
	}

	public RegisterForm() {
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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

}
