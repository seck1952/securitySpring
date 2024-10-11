package securitySpring.seck.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import securitySpring.seck.service.JWTAuthaurizationFilter;
import securitySpring.seck.service.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	BCryptPasswordEncoder bcrypt;
	@Autowired
	UserDetailsService userDetailsService;
	
//	AuthenticationManager authenticationManager;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication().withUser("admin").password(bcrypt.encode("1234")).roles("admin","user")
		.and().withUser("user").password("{noop}4567").roles("user");*/
		auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		//http.formLogin();
		http.authorizeRequests().antMatchers("/login/**","/register/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/tasks/**").hasAuthority("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthaurizationFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}
	
	

}
