package com.example.mobilebackendmaks.service;

import com.example.mobilebackendmaks.repository.ProjectRepository;
import com.example.mobilebackendmaks.user.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public List<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public List<Project> getUserProject(String userId){
        return projectRepository.findByUserUserId(userId);
    }
    public Optional<Project> getProjectById(String id){
        return projectRepository.findById(id);
    }
    public Project create(Project project){
        return projectRepository.save(project);
    }
    public Project update(Project project){
        Optional<Project> findOptional = projectRepository.findById(project.getProjectId());
        if(findOptional.isPresent()){
            Project project1 = findOptional.get();
            if(project1.getTitle()==null){
                project.setTitle(project1.getTitle());
            }
            if(project.getStartDate()==null){
                project.setStartDate(project1.getStartDate());
            }
            if(project.getDeadlineDate()==null){
                project.setDeadlineDate(project1.getDeadlineDate());
            }
            if(project.getDescription()==null){
                project.setDescription(project1.getDescription());
            }
            if(project.getUser()==null){
                project.setUser(project1.getUser());
            }
        }
        return projectRepository.save(project);
    }
}
