package com.custom.datasources.service;

import com.custom.datasources.model.Student;
import com.custom.datasources.repository.StudentDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService implements StudentDAO<Student> {

    private final JdbcTemplate jdbcTemplate;

    public StudentService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Student> rowMapper = (rs, rowNum) -> {
        Student student = new Student();
        student.setStudent_id(rs.getString("student_id"));
        student.setFirst_name(rs.getString("first_name"));
        student.setLast_name(rs.getString("last_name"));
        return student;
    };

    @Override
    public List<Student> getAll() {
        String query = "select  * from students";
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public Student create(Student student) {
        String query = "insert into students(student_id, first_name, last_name) values" +
                "(?,?,?)";
            jdbcTemplate.update(query,
                    student.getFirst_name(),
                    student.getLast_name(),
                    student.getStudent_id());
        return student;
    }

    @Override
    public Student update(Student student) {
        String query = "update students set student_id = ? , first_name = ?, last_name = ?";
        jdbcTemplate.update(query, student.getStudent_id(), student.getFirst_name(), student.getLast_name());
        return student;
    }

    @Override
    public int delete(Student student) {
        String query = "delete from students where student_id = ?";
        return jdbcTemplate.update(query, student.getStudent_id());
    }

    @Override
    public Student getById(Student student) {
        String query = "select * from students where student_id = ?";
        jdbcTemplate.queryForObject(query, rowMapper, student.getStudent_id());
        return student;
    }
}
