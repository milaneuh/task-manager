package com.dev.task_manager.tasks;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Controller
class TaskController {
    private final TaskRepository taskRepository;

    TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}

@Repository
interface TaskRepository extends CrudRepository<Task, UUID> {}

@Table(name = "task")
class Task {
    @Id
    private final UUID id = UUID.randomUUID();
    private String description;
    private boolean done;

    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void unFinishTask(){
        this.done = false;
    }

    public void finishTask(){
       this.done = true;
    }
}
