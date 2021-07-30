package sam.rus.rostov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sam.rus.rostov.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
