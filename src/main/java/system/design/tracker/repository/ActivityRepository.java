package system.design.tracker.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import system.design.tracker.entity.Activity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ActivityRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // ✅ Insert a new activity
    public int insertActivity(Activity activity) {
        String sql = "INSERT INTO activity (category, description, comments, created_at) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                activity.getCategory(),
                activity.getDescription(),
                activity.getComments(),
                activity.getCreatedAt() // Automatically set current timestamp
        );
    }

    // ✅ Retrieve all activities
    public List<Activity> getAllActivities() {
        String sql = "SELECT * FROM activity";
        return jdbcTemplate.query(sql, new ActivityRowMapper());
    }

    // RowMapper for mapping ResultSet to Activity object
    private static class ActivityRowMapper implements RowMapper<Activity> {
        @Override
        public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {
            Activity activity = new Activity();
            activity.setId(rs.getInt("id"));
            activity.setCategory(rs.getString("category"));
            activity.setDescription(rs.getString("description"));
            activity.setComments(rs.getString("comments"));
            activity.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            return activity;
        }
    }
}

