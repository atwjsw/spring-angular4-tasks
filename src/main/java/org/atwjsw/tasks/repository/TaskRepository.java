package org.atwjsw.tasks.repository;

import org.atwjsw.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
