package com.example.Activity_Project.api;

import com.example.Activity_Project.dto.ActivityDto;
import com.example.Activity_Project.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {

    @Autowired
    private IActivityService iActivityService;

    @PostMapping("/addActivity")
    public ResponseEntity<ActivityDto> addActivity(@RequestBody ActivityDto activityDto)
    {
        return iActivityService.addActivity(activityDto);
    }



}
