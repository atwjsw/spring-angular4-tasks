package org.atwjsw.tasks;

import org.atwjsw.tasks.domain.Task;
import org.atwjsw.tasks.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@SpringBootApplication
public class TasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasksApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(TaskService taskService) {
        return args -> {
            taskService.save(new Task(null, "Create Spring Boot Application", LocalDate.now(), true));
            taskService.save(new Task(null, "Create Spring Boot Project Packages", LocalDate.now().plus(1, DAYS), true));
            taskService.save(new Task(null, "Create the task Domain Class", LocalDate.now().plus(3, DAYS), false));
            taskService.save(new Task(null, "Create the service and repository classes", LocalDate.now().plus(5, DAYS), false));
            taskService.save(new Task(null, "create the command line runner to load data", LocalDate.now().plus(8, DAYS), false));
            taskService.save(new Task(null, "create the required configuration properties", LocalDate.now().plus(10, DAYS), false));
            taskService.save(new Task(null, "Run the spring boot application", LocalDate.now().plus(12, DAYS), false));
            taskService.save(new Task(null, "Check the H2 console for the initial data", LocalDate.now().plus(13, DAYS), false));
        };
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/api/**").allowedOrigins("http://localhost:4200");
//            }
//        };
//    }
}

