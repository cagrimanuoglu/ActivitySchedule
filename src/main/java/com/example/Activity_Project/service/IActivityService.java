package com.example.Activity_Project.service;

import com.example.Activity_Project.dto.ActivityDto;
import com.example.Activity_Project.entity.Activity;
import org.springframework.http.ResponseEntity;

public interface IActivityService {

    Activity getByid(Long id);
    ResponseEntity<ActivityDto> addActivity(ActivityDto activityDto);

}
