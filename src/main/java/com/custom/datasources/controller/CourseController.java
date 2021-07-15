package com.custom.datasources.controller;

import com.custom.datasources.model.Course;
import com.custom.datasources.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping()
    public List<Course> getCourses(){
        return courseService.getCourses();
    }
}
