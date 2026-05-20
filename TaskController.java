package com.team.taskmanager.controller;

import com.team.taskmanager.model.Task;
import jakarta.validation.Valid;
import com.team.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Get all tasks
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    // Add task
    @PostMapping
    public Task addTask(@Valid @RequestBody Task task){
        return taskService.saveTask(task);
    }

    // Get task by ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // Update task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,
                           @RequestBody Task updatedTask) {

        return taskService.updateTask(id, updatedTask);
    }

    // Delete task
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);

        return "Task deleted successfully";
    }
}