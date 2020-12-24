package com.example.Activity_Project.dto;

public class ActivityDto {

    private Long id;
    private String activityname;
    private Long user_id;

    public ActivityDto() {
    }

    public ActivityDto(Long id, String activityname, Long user_id) {
        this.id = id;
        this.activityname = activityname;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
