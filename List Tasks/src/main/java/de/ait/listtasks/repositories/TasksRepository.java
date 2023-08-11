package de.ait.listtasks.repositories;

import de.ait.listtasks.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Task, Long> {
}
