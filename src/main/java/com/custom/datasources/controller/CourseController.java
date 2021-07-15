package com.custom.datasources.controller;

import com.custom.datasources.model.Course;
import com.custom.datasources.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping()
    public List<Course> getCourses(){
        return courseService.getAll();
    }

    @PostMapping("/add")
    public Course create(@RequestBody Course course){
        return courseService.create(course);
    }

    @PutMapping("/edit/{id}")
    public Course update(@RequestBody Course course, @PathVariable("id") int course_id){
        return courseService.update(course, course_id);
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable("id") int course_id){
         return courseService.delete(course_id);
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable("id") int course_id){
        return courseService.getById(course_id);
    }
}
