package com.example.mobilebackendmaks.service;

import com.example.mobilebackendmaks.repository.TaskRepository;
import com.example.mobilebackendmaks.user.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getProjectTask(String projectId, String userId){
        return taskRepository.findAllByProjectProjectIdAndUserUserId(projectId,userId);
    }
    public List<Task> getTaskByIds(List<String> ids, String userId){
        return taskRepository.getTaskByIds(ids,userId);
    }
    public Optional<Task> getTaskById(String taskId){
        return taskRepository.findById(taskId);
    }
    public Task updateTask(Task task){
        Optional<Task> taskOptional = taskRepository.findById(task.getTaskId());
        if(taskOptional.isPresent()){
            Task taskFromOptional = taskOptional.get();
            if(task.getDescription()==null){
                task.setDescription(taskFromOptional.getDescription());
            }
            if(task.getResultDescription()==null){
                task.setDescription(taskFromOptional.getDescription());
            }
            if(task.getUser()==null){
                task.setUser(taskFromOptional.getUser());
            }
            if(task.getProject()==null){
                task.setProject(taskFromOptional.getProject());
            }
        }
        return taskRepository.save(task);
    }
    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    public List<Task> getUserTask(String id){
        return taskRepository.findAllByUserIdAndDeadlineNotPassed(id);
    }
}
