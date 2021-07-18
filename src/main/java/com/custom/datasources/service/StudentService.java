package com.custom.datasources.service;

import com.custom.datasources.model.Student;
import com.custom.datasources.repository.DAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService implements DAO<Student> {

    private final JdbcTemplate jdbcTemplate;

    public StudentService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Student> rowStudents = (rs, rowNum) -> {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setStudent_id(rs.getString("student_id"));
        student.setFirst_name(rs.getString("first_name"));
        student.setLast_name(rs.getString("last_name"));
        return student;
    };

    @Override
    public List<Student> getAll() {
        String query = "select  * from students";
        return jdbcTemplate.query(query, rowStudents);
    }

    @Override
    public Student create(Student student) {
        String query = "insert into students(student_id, first_name, last_name) values" +
                "(?,?,?)";
            jdbcTemplate.update(query,
                    student.getStudent_id(),
                    student.getFirst_name(),
                    student.getLast_name());

        return student;
    }

    @Override
    public Student update(Student student, int id) {
        String query = "update students set student_id = ? , first_name = ?, last_name = ? where id = ?";
        jdbcTemplate.update(query,
                student.getStudent_id(),
                student.getFirst_name(),
                student.getLast_name(),
                id);
        return student;
    }

    @Override
    public int delete(int id) {
        String query = "delete from students where id = ?";
        return jdbcTemplate.update(query, id);
    }

    @Override
    public Student getById(int id) {
        String query = "select * from students where id = ?";
        return jdbcTemplate.queryForObject(query, rowStudents, id);
    }
}
