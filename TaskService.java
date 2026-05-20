package com.team.taskmanager.service;

import com.team.taskmanager.model.Task;
import com.team.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Save task
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // Get task by ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // Update task
    public Task updateTask(Long id, Task updatedTask) {

        Task task = taskRepository.findById(id).orElse(null);

        if(task != null) {
            task.setTitle(updatedTask.getTitle());
            task.setStatus(updatedTask.getStatus());

            return taskRepository.save(task);
        }

        return null;
    }

    // Delete task
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}