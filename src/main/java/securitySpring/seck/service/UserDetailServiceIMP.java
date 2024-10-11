package securitySpring.seck.service;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import securitySpring.seck.entity.AppUser;
@Service
public class UserDetailServiceIMP implements UserDetailsService{
	@Autowired
	AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = accountService.findUserByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
			
		}
		Collection<GrantedAuthority> authories = new ArrayList<>();
		user.getAppRoles().forEach(e->{
			authories.add(new SimpleGrantedAuthority(e.getRolename()));
		});
		return new User(user.getUsername(),user.getPassword(),authories);
	}

}
