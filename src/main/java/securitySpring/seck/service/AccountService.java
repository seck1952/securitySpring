package securitySpring.seck.service;

import securitySpring.seck.entity.AppRole;
import securitySpring.seck.entity.AppUser;

public interface AccountService {
	public AppUser addUser(AppUser appUser);
	public AppRole addRole(AppRole appRole);
	public void addRoleToUser(String username,String role);
	public AppUser findUserByUsername(String username);

}
