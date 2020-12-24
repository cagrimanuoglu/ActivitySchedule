package com.example.Activity_Project.mapper;

import com.example.Activity_Project.dto.ActivityDto;
import com.example.Activity_Project.entity.Activity;
import com.example.Activity_Project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityMapperService implements IActivitiyMapper{

    @Autowired
    private IUserService iUserService;

    @Override
    public Activity fromDto(ActivityDto activityDto) {
        Activity activity = new Activity();
        activity.setActivityname(activityDto.getActivityname());
        activity.setId(activityDto.getId());
        activity.setUser(iUserService.getByid(activityDto.getUser_id()).get());
        return activity;
    }

    @Override
    public ActivityDto toDto(Activity activity) {

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityname(activity.getActivityname());
        activityDto.setId(activity.getId());
        activityDto.setUser_id(activity.getUser().getId());

        return activityDto;
    }
}
