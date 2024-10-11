package securitySpring.seck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import securitySpring.seck.entity.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long>{
	public AppRole findByRolename(String role);

}
