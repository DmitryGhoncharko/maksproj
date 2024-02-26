package com.example.mobilebackendmaks.service;

import com.example.mobilebackendmaks.repository.WorklogRepository;
import com.example.mobilebackendmaks.user.Worklog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorklogService {
    private final WorklogRepository worklogRepository;

    public List<Worklog> getDayWorkLog(Date startDate, Date endDate, String userId){
       return worklogRepository.findAllByUserIdAndLogDateBetween(userId,startDate,endDate);
    }
    public Optional<Worklog> getWorkLogById(String id){
        return worklogRepository.findById(id);
    }
    public Worklog create(Worklog worklog){
        return worklogRepository.save(worklog);
    }
    public Worklog update(Worklog worklog){
        Optional<Worklog> worklogOptional = worklogRepository.findById(worklog.getWorklogId());
        if(worklogOptional.isPresent()){
            Worklog worklogFromOptional = worklogOptional.get();
            if(worklog.getDescription()==null){
                worklog.setDescription(worklogFromOptional.getDescription());
            }
            if(worklog.getLogDate()==null){
                worklog.setLogDate(worklogOptional.get().getLogDate());
            }
            if(worklog.getTask()==null){
                worklog.setTask(worklogFromOptional.getTask());
            }
            if(worklog.getUser()==null){
                worklog.setUser(worklogFromOptional.getUser());
            }
            if(worklog.getProject()==null){
                worklog.setProject(worklogOptional.get().getProject());
            }
        }
        return worklogRepository.save(worklog);
    }
    public void deleteLogById(String id){
        worklogRepository.deleteById(id);
    }

}
