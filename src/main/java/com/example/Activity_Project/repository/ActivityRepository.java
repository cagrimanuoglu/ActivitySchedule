package com.example.Activity_Project.repository;

import com.example.Activity_Project.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Long> {
}
