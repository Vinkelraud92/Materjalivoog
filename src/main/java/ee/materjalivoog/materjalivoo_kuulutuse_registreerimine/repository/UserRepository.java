package ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createUser(String userName, String password, int accountNumber, int region,
                           String billingAddress, String shippingAddress, String role) {
        String sql = "INSERT INTO \"user\" (user_name, password, account_number, region," +
                "billing_address, shipping_address, role) VALUES (:userName, :password, :account_number," +
                ":region, :billing_address, :shipping_address, :role)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", userName);
        paramMap.put("password", password);
        paramMap.put("account_number", accountNumber);
        paramMap.put("region", region);
        paramMap.put("billing_address", billingAddress);
        paramMap.put("shipping_address", shippingAddress);
        paramMap.put("role", role);
        jdbcTemplate.update(sql, paramMap);
    }

    public String getPassword(String userName, String password){
        String sql = "SELECT password FROM \"user\";
        Map<String, Object> paramMap = new HashMap<>();
    }
}
