package com.techelevator.dao;

import com.techelevator.model.Categories;
import com.techelevator.model.UserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component

public class JdbcCategoriesDAO implements CategoriesDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcCategoriesDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Categories getCategory(int categoryId) {
        Categories category = null;
        String query = "SELECT * FROM categories WHERE category_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(query, categoryId);
        while (results.next()) category = mapRowToCategories(results);
        return category;
    }

    public Categories mapRowToCategories(SqlRowSet results) {
        Categories category = new Categories();
        category.setCategoryId(results.getInt("category_id"));
        category.setCategoryName(results.getString("category_name"));
        return category;
    }

}
