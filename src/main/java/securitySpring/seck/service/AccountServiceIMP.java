package securitySpring.seck.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import securitySpring.seck.entity.AppRole;
import securitySpring.seck.entity.AppUser;
import securitySpring.seck.repositories.RoleRepository;
import securitySpring.seck.repositories.UserRepository;
@Service
@Transactional
public class AccountServiceIMP implements AccountService{
	@Autowired
	BCryptPasswordEncoder bcrypt;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Override
	public AppUser addUser(AppUser appUser) {
		String pwd=bcrypt.encode(appUser.getPassword());
	    appUser.setPassword(pwd);
		return userRepository.save(appUser);
	}

	@Override
	public AppRole addRole(AppRole appRole) {
		
		return roleRepository.save(appRole);
	}

	@Override
	public void addRoleToUser(String username, String role) {
		AppUser user = userRepository.findByUsername(username);
		AppRole roles = roleRepository.findByRolename(role);
		user.getAppRoles().add(roles);
		
	}

	@Override
	public AppUser findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

}
