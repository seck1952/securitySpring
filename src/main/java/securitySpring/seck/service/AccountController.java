package securitySpring.seck.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import securitySpring.seck.entity.AppUser;
import securitySpring.seck.entity.RegisterForm;
import securitySpring.seck.entity.Task;
import securitySpring.seck.repositories.TaskRepository;
@CrossOrigin("*")
@RestController
public class AccountController {
	@Autowired
	TaskRepository tasks;
	@Autowired
	AccountService accountService;
	public AppUser register(@RequestBody RegisterForm register) {
		if(!register.getPassword().equals(register.getRepassword()))
			throw new RuntimeException("les deux Mot de Passe ne se correspond pas");
		AppUser user=accountService.findUserByUsername(register.getUsername());
		if(user!=null) {
			throw new RuntimeException("le username existe deja");
		}
		AppUser appUser=new AppUser();
		appUser.setUsername(register.getUsername());
		appUser.setPassword(register.getPassword());
		accountService.addUser(appUser);
		accountService.addRoleToUser(register.getUsername(), "USER");
		return appUser;
	}
	@GetMapping(value="/liste")
	public List<Task> getTask(){
		List<Task> task = tasks.findAll();
		return task;
	}

}
