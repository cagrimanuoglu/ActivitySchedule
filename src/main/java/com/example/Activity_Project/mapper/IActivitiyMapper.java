package com.example.Activity_Project.mapper;

import com.example.Activity_Project.dto.ActivityDto;
import com.example.Activity_Project.entity.Activity;

public interface IActivitiyMapper {

    Activity fromDto(ActivityDto activityDto);
    ActivityDto toDto(Activity activity);
}
