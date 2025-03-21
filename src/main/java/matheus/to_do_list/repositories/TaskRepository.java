package matheus.to_do_list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import matheus.to_do_list.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
