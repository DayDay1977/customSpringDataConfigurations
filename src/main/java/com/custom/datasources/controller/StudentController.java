package com.custom.datasources.controller;

import com.custom.datasources.model.Student;
import com.custom.datasources.service.StudentService;
import com.custom.datasources.utils.StudentDetailsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDetailsUtils studentDetailsUtils;

    @GetMapping()
    private List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") int id){
        return studentService.getById(id);
    }

    @PostMapping("/add")
    private Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @PutMapping("/edit/{id}")
    private Student update(@RequestBody Student student, @PathVariable("id") int id){
        return studentService.update(student, id);
    }

    @DeleteMapping("/delete/{id}")
    private int delete(@PathVariable("id") int id){
        return studentService.delete(id);
    }

    @GetMapping("/{student_id}/details")
    private Student getDetails(@PathVariable("student_id") String student_id){
        return studentDetailsUtils.getDetails(student_id);
    }

    @PostMapping("/course")
    private void addCourses(@RequestParam("student_id") String student_id, @RequestParam("courses") List<Integer> courses){
        studentDetailsUtils.addCourses(student_id, courses);
    }

    @PostMapping("/hall")
    private String addHall(@RequestParam("student_id") String student_id, @RequestParam("hall") int hall){
        return studentDetailsUtils.addHall(student_id, hall);
    }
}
