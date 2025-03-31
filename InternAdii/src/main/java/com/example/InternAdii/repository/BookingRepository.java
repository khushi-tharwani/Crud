package com.example.InternAdii.repository;

import com.example.InternAdii.model.Booking;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class BookingRepository {
    private final JdbcTemplate jdbcTemplate;

    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Insert a new booking
    public void save(Booking booking) {
        String sql = "INSERT INTO bookings (id, load_id, transporter_id, proposed_rate, comment, requested_at, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                booking.getId(),
                booking.getLoadId(),
                booking.getTransporterId(),
                booking.getProposedRate(),
                booking.getComment(),
                booking.getRequestedAt(),
                booking.getStatus()
        );
    }

    // Fetch all bookings
    public List<Booking> findAll() {
        String sql = "SELECT * FROM bookings";
        return jdbcTemplate.query(sql, new BookingRowMapper());
    }

    // Fetch booking by ID
    public Booking findById(UUID id) {
        String sql = "SELECT * FROM bookings WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BookingRowMapper(), id);
    }

    // Update booking
    public void update(Booking booking) {
        String sql = "UPDATE bookings SET load_id = ?, transporter_id = ?, proposed_rate = ?, " +
                "comment = ?, requested_at = ?, status = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                booking.getLoadId(),
                booking.getTransporterId(),
                booking.getProposedRate(),
                booking.getComment(),
                booking.getRequestedAt(),
                booking.getStatus(),
                booking.getId()
        );
    }

    // Delete booking
    public void delete(UUID id) {
        String sql = "DELETE FROM bookings WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // RowMapper for Booking entity
    private static class BookingRowMapper implements RowMapper<Booking> {
        @Override
        public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
            Booking booking = new Booking();
            booking.setId(UUID.fromString(rs.getString("id")));
            booking.setLoadId(UUID.fromString(rs.getString("load_id")));
            booking.setTransporterId(rs.getString("transporter_id"));
            booking.setProposedRate(rs.getDouble("proposed_rate"));
            booking.setComment(rs.getString("comment"));
            booking.setRequestedAt(rs.getTimestamp("requested_at"));
            booking.setStatus(rs.getString("status"));
            return booking;
        }
    }
}
