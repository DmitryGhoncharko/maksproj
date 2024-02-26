package com.example.mobilebackendmaks.repository;

import com.example.mobilebackendmaks.user.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,String> {
    List<Project> findByUserUserId(String userId);

    List<Project> findByTitle(String title);
}
