package com.custom.datasources.service;

import com.custom.datasources.model.Course;
import com.custom.datasources.repository.DAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseService implements DAO<Course> {

    private final JdbcTemplate jdbcTemplate;

    public CourseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Course> rowMapper = (rs, rowNum) -> {
        Course course = new Course();
        course.setCourse_id(rs.getInt("course_id"));
        course.setCourse_name(rs.getString("course_name"));
        return course;
    };

    @Override
    public List<Course> getCourses() {
        String query = "select * from courses";
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public Course create(Course course) {
        return null;
    }

    @Override
    public Course update(Course course, int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Course getById(int id) {
        return null;
    }

    @Override
    public void insert(Course course) {

    }
}
