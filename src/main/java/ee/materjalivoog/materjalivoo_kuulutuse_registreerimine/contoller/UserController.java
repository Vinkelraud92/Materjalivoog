package ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.contoller;

import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.User;
import ee.materjalivoog.materjalivoo_kuulutuse_registreerimine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("api/listing/createuser")
    public void createUser(@RequestBody User user) {
        userService.createUser(user.getUserName(), user.getPassword(), user.getAccountNumber(),
                user.getRegion(), user.getBillingAddress(), user.getShippingAddress(), user.getRole());
    }

    @PostMapping("api/listing/login")
    public void login (@RequestBody User user) {
        userService.login(user.getUserName(), user.getPassword());
    }
}
