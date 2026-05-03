package com.rudra.Feedback;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.*;

import java.util.List;

@Repository
public class FeedbackDAO {
    private final JdbcTemplate jt;

    public FeedbackDAO(JdbcTemplate jt) {
        this.jt = jt;
    }

    public int save(Feedback f) {
        String sql = "INSERT INTO feedback (name, feedback) VALUES (?, ?)";
        return jt.update(sql, f.getName(), f.getFeedback());
    }

    public List<Feedback> getAll() {
        String sql = "SELECT * FROM feedback";
        return jt.query(sql, new BeanPropertyRowMapper<>(Feedback.class));
    }
}
