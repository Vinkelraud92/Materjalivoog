package ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.repository;

import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ListingRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public int createListing(int listingId, int userId, int category, int subcategory, boolean deadStock, String title,
                             String description1, double unitPrice, String unitType, int inventory, boolean inStock,
                             double profit, String description2, double discountPrice, double discountPercentage,
                             int region, String location, String restriction, String transport) {
        String sql = "INSERT INTO listing (listing_id, user_id, category, subcategory, dead_stock, title, description_1," +
                "unit_price, unit_type, inventory, in_stock, profit, description_2, discount_price, discount_percentage," +
                "region, location, restriction, transport) VALUES (:listing_id, :user_id, :category, :subcategory, :dead_stock," +
                ":title, :description_1, :unit_price, :unit_type, :inventory, :in_stock, :profit, :description_2," +
                ":discount_price, :discount_percentage, :region, :location, :restriction, :transport)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("listing_id", listingId);
        paramMap.put("user_id", userId);
        paramMap.put("category", category);
        paramMap.put("subcategory", subcategory);
        paramMap.put("dead_stock", deadStock);
        paramMap.put("title", title);
        paramMap.put("description_1", description1);
        paramMap.put("unit_price", unitPrice);
        paramMap.put("unit_type", unitType);
        paramMap.put("inventory", inventory);
        paramMap.put("in_stock", inStock);
        paramMap.put("profit", profit);
        paramMap.put("description_2", description2);
        paramMap.put("discount_price", discountPrice);
        paramMap.put("discount_percentage", discountPercentage);
        paramMap.put("region", region);
        paramMap.put("location", location);
        paramMap.put("restriction", restriction);
        paramMap.put("transport", transport);
        jdbcTemplate.update(sql, paramMap);
        return listingId;
    }

    public List getCategories() {
        String sql = "SELECT name FROM category";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.queryForList(sql, paramMap, String.class);

    }

    public List getSubcategories() {
        String sql = "SELECT name FROM subcategory";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.queryForList(sql, paramMap, String.class);

    }

    public List selectSubcategories(Integer category_id) {
        String sql = "SELECT category_id, name, subcategory_id FROM subcategory WHERE category_id= :category_id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("category_id", category_id);
        List<Subcategory> result = jdbcTemplate.query(sql, paramMap,new SubcategoryDtoMapper());
        return result;
    }

    private class SubcategoryDtoMapper implements RowMapper<Subcategory> {
        @Override
        public Subcategory mapRow(ResultSet resultSet, int i) throws SQLException {
            Subcategory result = new Subcategory();
            result.setCategoryId(resultSet.getInt("category_id"));
            result.setName(resultSet.getString("name"));
            result.setSubcategoryId(resultSet.getInt("subcategory_id"));
            return result;
        }
    }
}
