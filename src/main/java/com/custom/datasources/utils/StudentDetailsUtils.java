package com.custom.datasources.utils;

import com.custom.datasources.model.Course;
import com.custom.datasources.model.Hall;
import com.custom.datasources.model.Student;
import com.custom.datasources.repository.StudentUtilsDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDetailsUtils implements StudentUtilsDAO<Student> {

    private final JdbcTemplate jdbcTemplate;

    public StudentDetailsUtils(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Course> rowCourses = (rs, rowNum) -> {
        Course course = new Course();
        course.setCourse_id(rs.getInt("course_id"));
        course.setCourse_name(rs.getString("course_name"));
        return course;
    };

    RowMapper<Hall> rowHalls = (rs, rowNum) -> {
        Hall hall = new Hall();
        hall.setHall_id(rs.getInt("hall_id"));
        hall.setHall_name(rs.getString("hall_name"));
        return hall;
    };

    @Override
    public String addCourses(String s, List<Integer> course) {
        int count = 0;
        while(count < course.size()) {

            String courseQuery = "insert into student_courses values (?,?)";

            jdbcTemplate.update(courseQuery,
                    s,
                    course.get(count));
            count++;
        }
        return "Course added successfully";
    }

    @Override
    public String addHall(String s, int t) {
        String query = "insert into student_halls values (?,?)";
        jdbcTemplate.update(query, s, t);
        return "Inserted successfully";
    }

    @Override
    public int removeCourses(String s) {
        String query = "delete from student_courses where student_id = ?";
        return jdbcTemplate.update(query, s);
    }

    @Override
    public int editHall(String s, int hall) {
        String query = "update student_halls set hall_id = ? where student_id = ?";
        return jdbcTemplate.update(query, hall, s);
    }

    @Override
    public Student getDetails(String student_id) {
        Student student = new Student();
        String courseQuery = "select courses.course_id, course_name from courses " +
                "left join student_courses on student_courses.course_id = courses.course_id " +
                "left join students on students.student_id = student_courses.student_id " +
                "where students.student_id = '" + student_id + "'";
        List<Course> courses = jdbcTemplate.query(courseQuery, rowCourses);

        String hallQuery = "select halls.hall_id, hall_name from halls " +
                "left join student_halls on student_halls.hall_id = halls.hall_id " +
                "left join students on students.student_id = student_halls.student_id " +
                "where students.student_id = ? ";

        Hall hall = jdbcTemplate.queryForObject(hallQuery, rowHalls, student_id);

        String studentQuery = "select * from students where student_id = ?";
        jdbcTemplate.queryForObject(studentQuery, (rs, rowNum) -> {
            student.setId(rs.getInt("id"));
            student.setStudent_id(rs.getString("student_id"));
            student.setFirst_name(rs.getString("first_name"));
            student.setLast_name(rs.getString("last_name"));
            student.setCourses(courses);
            student.setHall_name(hall);
           return student;
       }, student_id);
        return student;
    }
}
