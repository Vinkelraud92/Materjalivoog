package ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.service;


import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.exceptions.ApplicationException;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.repository.UserRepository;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(String userName, String password, int accountNumber, int region,
                           String billingAddress, String shippingAddress, String role) {
        String encodedPassword = passwordEncoder.encode(password);
        {
            userRepository.createUser(userName, encodedPassword, accountNumber, region, billingAddress,
                    shippingAddress, role);
        }
    }
    public void login (String userName, String password) {
        //String encodedPassword = userRepository.getPassword(userName);
//        if (passwordEncoder.matches(password, encodedPassword)) {
//            JwtBuilder builder = Jwts.builder()
//                    .signWith(SignatureAlgorithm.HS256, "secret")
//                    .claim("username", userName);
//        }else{
//            throw new ApplicationException( "Parool on vale");
//        }
    }
}
