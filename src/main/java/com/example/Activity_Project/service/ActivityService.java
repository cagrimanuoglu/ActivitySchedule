package com.example.Activity_Project.service;

import com.example.Activity_Project.dto.ActivityDto;
import com.example.Activity_Project.entity.Activity;
import com.example.Activity_Project.mapper.ActivityMapper;
import com.example.Activity_Project.mapper.IActivitiyMapper;
import com.example.Activity_Project.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ActivityService implements IActivityService{

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private IActivitiyMapper iActivitiyMapper;

    @Override
    public Activity getByid(Long id) {
        return activityRepository.getOne(id);
    }

    @Override
    public ResponseEntity<ActivityDto> addActivity(ActivityDto activityDto) {
        Activity activity;
        ActivityDto activityDto1;
        activity=iActivitiyMapper.fromDto(activityDto);
        activity=activityRepository.save(activity);
        activityDto1 = iActivitiyMapper.toDto(activity);
        return ResponseEntity.ok(activityDto1);
    }
}
