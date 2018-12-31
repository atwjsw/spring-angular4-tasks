package org.atwjsw.tasks.controller;

import org.atwjsw.tasks.domain.Task;
import org.atwjsw.tasks.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping({"", "/"})
    public Iterable<Task> listTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping({"", "/"})
    public Task saveTask(@RequestBody Task task) {
        return taskService.save(task);
    }
//
//    @PutMapping({"/{id}", "/{id}/"})
//    public Task saveTask(@RequestBody Task task, @PathVariable Long id) {
//        return taskService.save(task);
//    }
}
