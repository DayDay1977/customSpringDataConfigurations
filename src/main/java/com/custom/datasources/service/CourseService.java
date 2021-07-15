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
    public List<Course> getAll() {
        String query = "select * from courses";
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public Course create(Course course) {
        String query = "insert into courses(course_name) values (?)";
        jdbcTemplate.update(query,course.getCourse_name());
        return course;
    }

    @Override
    public Course update(Course course, int id) {
        String query = "update courses set course_name = ? where course_id = ?";
        jdbcTemplate.update(query, course.getCourse_name(), id);
        return null;
    }

    @Override
    public int delete(int id) { //return type int to be able to identify non existent course_id's
        String query = "delete from courses where course_id = ?";
        return jdbcTemplate.update(query, id);
    }

    @Override
    public Course getById(int id) {
        String query = "select * from courses where course_id = ?";
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }
}
