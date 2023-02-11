package com.rayshan.controller;

import com.rayshan.common.entities.LoginActivity;
import com.rayshan.repository.LoginActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    private LoginActivityRepository activityRepository;

    @Autowired
    public ActivityController(LoginActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }

    @GetMapping("")
    public List<LoginActivity> getAllActivities() {
        return this.activityRepository.findAll();
    }

    @DeleteMapping("")
    public void deleteAllActivities() {
        this.activityRepository.deleteAll();
    }
}
