package com.custom.datasources.controller;

import com.custom.datasources.model.Hall;
import com.custom.datasources.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/halls")
public class HallController {

    @Autowired
    private HallService hallService;

    @GetMapping()
    private List<Hall> getAll(){
        return hallService.getAll();
    }

    @GetMapping("/{id}")
    private Hall getById(@PathVariable("id") int hall_id){
        return hallService.getById(hall_id);
    }

    @PostMapping("/add")
    private Hall create(@RequestBody Hall hall){
        return hallService.create(hall);
    }

    @PutMapping("/edit/{id}")
    private Hall update(@RequestBody Hall hall, @PathVariable("id") int hall_id){
        return hallService.update(hall, hall_id);
    }

    @DeleteMapping("/delete/{id}")
    private int delete(@PathVariable("id") int hall_id){
        return hallService.delete(hall_id);
    }
}
