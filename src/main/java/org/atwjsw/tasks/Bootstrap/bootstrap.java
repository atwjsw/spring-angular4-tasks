package org.atwjsw.tasks.Bootstrap;

import org.atwjsw.tasks.domain.Task;
import org.atwjsw.tasks.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public class bootstrap implements CommandLineRunner {

    private final TaskRepository taskRepository;

    public bootstrap(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        loadTasks();
    }

    private void loadTasks() {
        Task t1 = new Task(null, "task1", LocalDate.now(), false);
        Task t2 = new Task(null, "task2", LocalDate.now(), true);
        Task t3 = new Task(null, "task3", LocalDate.now(), false);
        Task t4 = new Task(null, "task4", LocalDate.now(), true);
        Task t5 = new Task(null, "task5", LocalDate.now(), false);

        taskRepository.save(t1);
        taskRepository.save(t2);
        taskRepository.save(t3);
        taskRepository.save(t4);
        taskRepository.save(t5);

        System.out.println("Tasks data loaded = " + taskRepository.count());
    }
}
