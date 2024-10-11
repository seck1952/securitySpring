package securitySpring.seck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import securitySpring.seck.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long>{
	public AppUser  findByUsername(String username);

}
