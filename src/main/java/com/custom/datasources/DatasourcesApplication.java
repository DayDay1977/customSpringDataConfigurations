package com.custom.datasources;

import com.custom.datasources.service.CourseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatasourcesApplication {

    private static CourseService courseService;

    public DatasourcesApplication(CourseService courseService){
        DatasourcesApplication.courseService = courseService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DatasourcesApplication.class, args);
    }
}
