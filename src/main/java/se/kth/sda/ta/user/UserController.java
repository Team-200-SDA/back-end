package se.kth.sda.ta.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.kth.sda.ta.auth.AuthService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public UserController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping("")
    public User getLoggedInUser(){
        String LoggedInUserEmail = authService.getLoggedInUserEmail();
        return userService.findUserByEmail(LoggedInUserEmail);
    }
}
