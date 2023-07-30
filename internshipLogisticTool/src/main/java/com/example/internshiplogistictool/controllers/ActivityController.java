package com.example.internshiplogistictool.controllers;

import com.example.internshiplogistictool.data.entity.Activity;
import com.example.internshiplogistictool.data.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/ ")
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @PostMapping
    public Activity createActivity(@RequestBody final Activity activity) {
        return activityService.createActivity(activity);
    }
}
