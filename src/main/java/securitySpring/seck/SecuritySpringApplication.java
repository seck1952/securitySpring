package securitySpring.seck;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import securitySpring.seck.entity.AppRole;
import securitySpring.seck.entity.AppUser;
import securitySpring.seck.entity.Task;
import securitySpring.seck.repositories.TaskRepository;
import securitySpring.seck.service.AccountService;

@SpringBootApplication
public class SecuritySpringApplication implements CommandLineRunner{
	@Autowired
	TaskRepository taskRepository;
	@Autowired
	AccountService accountService;
	@Autowired
	BCryptPasswordEncoder bcr;

	public static void main(String[] args) {
		SpringApplication.run(SecuritySpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.addUser(new AppUser(null, "admin","1234", null));
		accountService.addUser(new AppUser(null, "user","1234", null));
		accountService.addRole(new AppRole(null, "ADMIN"));
		accountService.addRole(new AppRole(null, "USER"));
	    accountService.addRoleToUser("admin", "ADMIN");
	    accountService.addRoleToUser("admin", "USER");
	    accountService.addRoleToUser("user", "USER");
		Stream.of("t1","t2","t3").forEach(e->taskRepository.save(new Task(null,e)));
		
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

}
