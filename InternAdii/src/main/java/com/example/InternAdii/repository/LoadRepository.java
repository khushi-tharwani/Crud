package com.example.InternAdii.repository;

import com.example.InternAdii.model.Load;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class LoadRepository {
    private final JdbcTemplate jdbcTemplate;

    public LoadRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Insert a new load
    public void save(Load load) {
        String sql = "INSERT INTO loads (id, shipper_id, loading_point, unloading_point, loading_date, unloading_date, " +
                "product_type, truck_type, no_of_trucks, weight, comment, date_posted, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                load.getId(),
                load.getShipperId(),
                load.getLoadingPoint(),
                load.getUnloadingPoint(),
                load.getLoadingDate(),
                load.getUnloadingDate(),
                load.getProductType(),
                load.getTruckType(),
                load.getNoOfTrucks(),
                load.getWeight(),
                load.getComment(),
                load.getDatePosted(),
                load.getStatus()
        );
    }

    // Fetch all loads
    public List<Load> findAll() {
        String sql = "SELECT * FROM loads";
        return jdbcTemplate.query(sql, new LoadRowMapper());
    }

    // Fetch load by ID
    public Load findById(UUID id) {
        String sql = "SELECT * FROM loads WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new LoadRowMapper(), id);
    }

    // Update load
    public void update(Load load) {
        String sql = "UPDATE loads SET shipper_id = ?, loading_point = ?, unloading_point = ?, " +
                "loading_date = ?, unloading_date = ?, product_type = ?, truck_type = ?, " +
                "no_of_trucks = ?, weight = ?, comment = ?, date_posted = ?, status = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                load.getShipperId(),
                load.getLoadingPoint(),
                load.getUnloadingPoint(),
                load.getLoadingDate(),
                load.getUnloadingDate(),
                load.getProductType(),
                load.getTruckType(),
                load.getNoOfTrucks(),
                load.getWeight(),
                load.getComment(),
                load.getDatePosted(),
                load.getStatus(),
                load.getId()
        );
    }

    // Delete load
    public void delete(UUID id) {
        String sql = "DELETE FROM loads WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // RowMapper for Load entity
    private static class LoadRowMapper implements RowMapper<Load> {
        @Override
        public Load mapRow(ResultSet rs, int rowNum) throws SQLException {
            Load load = new Load();
            load.setId(UUID.fromString(rs.getString("id")));
            load.setShipperId(rs.getString("shipper_id"));
            load.setLoadingPoint(rs.getString("loading_point"));
            load.setUnloadingPoint(rs.getString("unloading_point"));
            load.setLoadingDate(rs.getTimestamp("loading_date"));
            load.setUnloadingDate(rs.getTimestamp("unloading_date"));
            load.setProductType(rs.getString("product_type"));
            load.setTruckType(rs.getString("truck_type"));
            load.setNoOfTrucks(rs.getInt("no_of_trucks"));
            load.setWeight(rs.getDouble("weight"));
            load.setComment(rs.getString("comment"));
            load.setDatePosted(rs.getTimestamp("date_posted"));
            load.setStatus(rs.getString("status"));
            return load;
        }
    }
}

