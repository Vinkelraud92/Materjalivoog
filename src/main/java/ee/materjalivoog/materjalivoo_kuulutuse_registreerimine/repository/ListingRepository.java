package ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.repository;

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

    public int createListing(int listingId, int userId) {
        String sql = "INSERT INTO listing (listing_id, user_id) VALUES (:listing_id, :user_id)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("listing_id", listingId);
        paramMap.put("user_id", userId);
        jdbcTemplate.update(sql, paramMap);
        return listingId;

    }
}
