package com.dev.task_manager.tasks;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
class TaskController {
    private final TaskRepository taskRepository;

    TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "index";
    }

    @GetMapping("/edit-task/{id}")
    public String getEditPage(@PathVariable UUID id, Model model) throws Exception {
        taskRepository.findById(id).ifPresentOrElse(task -> model.addAttribute("task", task), () -> {
            throw new RuntimeException("Task not found, id = " + id);
        });
        return "edit-task";
    }

    @PatchMapping("/edit-task/{id}")
    public String editTask(@PathVariable UUID id, @RequestParam String description, Model model) {

        taskRepository.findById(id).ifPresentOrElse(task -> {
            task.setDescription(description);
            taskRepository.save(task);
        }, () -> {
            throw new RuntimeException("Task not found, id = " + id);
        });

        model.addAttribute("tasks", taskRepository.findAll());
        return "index";
    }

    @PostMapping("/add-task")
    public String addTask(@RequestParam String description, Model model) {
        Task newTask = new Task(description);
        taskRepository.save(newTask);
        model.addAttribute("task", newTask);
        return "task-row";
    }

    @DeleteMapping("/delete-task/{id}")
    @ResponseBody
    public void deleteTask(@PathVariable UUID id) {
        taskRepository.deleteById(id);
    }

}

@Repository
interface TaskRepository extends ListCrudRepository<Task, UUID> {
}

