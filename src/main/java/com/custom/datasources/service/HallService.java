package com.custom.datasources.service;

import com.custom.datasources.model.Hall;
import com.custom.datasources.repository.DAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HallService implements DAO<Hall> {

    private final JdbcTemplate jdbcTemplate;

    public HallService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Hall> rowMapper = (rs, rowNum) -> {
        Hall hall = new Hall();
        hall.setHall_id(rs.getInt("hall_id"));
        hall.setHall_name(rs.getString("hall_name"));
        hall.setHall_capacity(rs.getInt("hall_capacity"));
        return hall;
    };

    @Override
    public List<Hall> getAll() {
        String query = "select * from halls";
        return jdbcTemplate.query(query,rowMapper);
    }

    @Override
    public Hall create(Hall hall) {
        String query = "insert into halls(hall_name, hall_capacity) values (?,?)";
        jdbcTemplate.update(query, hall.getHall_name(), hall.getHall_capacity());
        return hall;
    }

    @Override
    public Hall update(Hall hall, int id) {
        String query = "update halls set hall_name = ? where hall_id = ?";
        jdbcTemplate.update(query, hall.getHall_name(), id);
        return hall;
    }

    @Override
    public int delete(int id) {
        String query = "delete from halls where hall_id = ?";
        return jdbcTemplate.update(query, id);
    }

    @Override
    public Hall getById(int id) {
        String query = "select * from halls where hall_id = ?";
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }
}
