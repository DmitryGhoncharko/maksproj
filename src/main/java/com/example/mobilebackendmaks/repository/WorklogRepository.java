package com.example.mobilebackendmaks.repository;

import com.example.mobilebackendmaks.user.Worklog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface WorklogRepository extends JpaRepository<Worklog,String> {
    @Query("SELECT w FROM Worklog w WHERE w.user.userId = :userId AND w.logDate BETWEEN :startDate AND :endDate")
    List<Worklog> findAllByUserIdAndLogDateBetween(String userId, Date startDate, Date endDate);


}
