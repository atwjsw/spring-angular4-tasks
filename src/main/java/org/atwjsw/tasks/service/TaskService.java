package org.atwjsw.tasks.service;

import org.atwjsw.tasks.domain.Task;

import java.util.List;

public interface TaskService {

    Iterable<Task> getAllTasks();

    Task save(Task task);
}
