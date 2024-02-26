package com.example.mobilebackendmaks.controller;

import com.example.mobilebackendmaks.service.WorklogService;
import com.example.mobilebackendmaks.user.Worklog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/worklogs")
public class WorklogController {

    private final WorklogService worklogService;

    public WorklogController(WorklogService worklogService) {
        this.worklogService = worklogService;
    }

    @GetMapping("/day")
    public ResponseEntity<List<Worklog>> getDayWorkLog(@RequestParam Date startDate, @RequestParam Date endDate, @RequestParam String userId) {
        List<Worklog> worklogs = worklogService.getDayWorkLog(startDate, endDate, userId);
        return ResponseEntity.ok(worklogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worklog> getWorkLogById(@PathVariable String id) {
        Optional<Worklog> worklog = worklogService.getWorkLogById(id);
        return worklog.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Worklog> createWorklog(@RequestBody Worklog worklog) {
        Worklog createdWorklog = worklogService.create(worklog);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWorklog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Worklog> updateWorklog(@PathVariable String id, @RequestBody Worklog worklog) {
        worklog.setWorklogId(id);
        Worklog updatedWorklog = worklogService.update(worklog);
        return ResponseEntity.ok(updatedWorklog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorklog(@PathVariable String id) {
        worklogService.deleteLogById(id);
        return ResponseEntity.noContent().build();
    }
}

