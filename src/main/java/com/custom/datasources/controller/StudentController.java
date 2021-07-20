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

    //GetMapping
    @GetMapping()
    private List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") int id) {
        return studentService.getById(id);
    }

    @GetMapping("/{student_id}/details")
    private Student getDetails(@PathVariable("student_id") String student_id) {
        return studentDetailsUtils.getDetails(student_id);
    }

    //PostMapping
    @PostMapping("/add")
    private Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @PostMapping("/details")
    private String addCourses(@RequestParam("student_id") String student_id,
                              @RequestParam("hall_id") int hall_id,
                              @RequestParam("courses") List<Integer> courses) {
        return studentDetailsUtils.addCourses(student_id, hall_id, courses);
    }

    //PutMapping
    @PutMapping("/edit/{id}")
    private Student update(@RequestBody Student student, @PathVariable("id") int id) {
        return studentService.update(student, id);
    }

    @PutMapping("/hall/edit")
    private int editHall(@RequestParam("student_id") String student_id, @RequestParam int hall) {
        return studentDetailsUtils.editHall(student_id, hall);
    }

    //DeleteMapping
    @DeleteMapping("/delete/{id}")
    private int delete(@PathVariable("id") int id) {
        return studentService.delete(id);
    }

    @DeleteMapping("/course/remove")
    private int removeCourse(@RequestParam("student_id") String student_id) {
        return studentDetailsUtils.removeCourses(student_id);
    }
}
