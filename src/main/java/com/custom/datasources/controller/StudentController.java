package com.custom.datasources.controller;

import com.custom.datasources.model.Student;
import com.custom.datasources.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    private List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") Student student){
        return studentService.getById(student);
    }

    @PostMapping("/add")
    private Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @PutMapping("/edit")
    private Student update(@RequestBody Student student){
        return studentService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    private int delete(@PathVariable("id") Student student){
        return studentService.delete(student);
    }
}
