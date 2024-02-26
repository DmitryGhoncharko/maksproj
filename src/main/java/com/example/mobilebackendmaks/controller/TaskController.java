package com.example.mobilebackendmaks.controller;

import com.example.mobilebackendmaks.service.TaskService;
import com.example.mobilebackendmaks.user.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/project")
    public ResponseEntity<List<Task>> getProjectTask(@RequestParam String projectId, @RequestParam String userId) {
        List<Task> tasks = taskService.getProjectTask(projectId, userId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody Task task) {
        task.setTaskId(id);
        Task updatedTask = taskService.updateTask(task);
        return ResponseEntity.ok(updatedTask);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Task>> getUserTask(@RequestParam String id) {
        List<Task> tasks = taskService.getUserTask(id);
        return ResponseEntity.ok(tasks);
    }
}

