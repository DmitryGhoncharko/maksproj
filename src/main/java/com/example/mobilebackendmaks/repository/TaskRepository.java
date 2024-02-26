package com.example.mobilebackendmaks.repository;

import com.example.mobilebackendmaks.user.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,String> {
    List<Task> findAllByProjectProjectIdAndUserUserId(String projectId, String userId);

    @Query("SELECT t FROM Task t WHERE t.taskId IN (:taskIdList) and t.user.userId in (:userId)")
    List<Task> getTaskByIds(List<String> taskIdList, String userId);

    @Query("SELECT t FROM Task t WHERE t.user.userId = :userId AND t.project.deadlineDate > CURRENT_DATE")
    List<Task> findAllByUserIdAndDeadlineNotPassed(@Param("userId") String userId);
}
