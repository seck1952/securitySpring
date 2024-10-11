package securitySpring.seck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import securitySpring.seck.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
