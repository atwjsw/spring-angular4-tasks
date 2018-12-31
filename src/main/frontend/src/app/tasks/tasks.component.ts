import { Component, OnInit } from '@angular/core';
import {Task} from './task.model';
import {HttpClient} from "@angular/common/http";
import {TaskService} from "./task-service";

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

    tasks: Array<Task>; //can object in array be strong typed?

  constructor(private taskService: TaskService) { }

  ngOnInit() {
      this.taskService.getAllTasks().subscribe(
          tasks => this.tasks = tasks,
          error => console.log(error)
      );
  }

  addNewTask(task: Task) {
      this.taskService.createOrUpdateTask(task).subscribe(
          savedTask => this.tasks.push(savedTask),
          error => console.log(error)
      );
  }

  toggleCompleted(task: Task) {
      this.taskService.createOrUpdateTask(task).subscribe(
          savedTask => {
              const index = this.tasks.findIndex(task => task.id === savedTask.id);
              this.tasks[index] = savedTask;
          },
          error => console.log(error)
      );
  }

}
