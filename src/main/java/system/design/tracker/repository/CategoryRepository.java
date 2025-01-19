package system.design.tracker.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import system.design.tracker.entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    // INSERT Method
    public void insertCategory(Category category) {
        String sql = "INSERT INTO categories (name, created_at) VALUES (?, ?)";
        jdbcTemplate.update(sql, category.getName(), new java.sql.Timestamp(category.getCreateDate().getTime()));
    }

    // SELECT Method - Retrieve all categories
    public List<Category> getAllCategories() {
        String sql = "SELECT id, name, created_at FROM categories";
        return jdbcTemplate.query(sql, new CategoryRowMapper());
    }

    // RowMapper for mapping ResultSet to Category object
    private static class CategoryRowMapper implements RowMapper<Category> {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            category.setCreateDate(rs.getTimestamp("created_at"));
            return category;
        }
    }
}
