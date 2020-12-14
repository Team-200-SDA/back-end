package se.kth.sda.ta.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.kth.sda.ta.auth.AuthService;

import java.util.List;

/**
 * This class is a RestController for User table and handles HTTP requests and responses
 * It contains methods to get user details from user service and auth service
 * and update user details to user repository through user service */

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

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("")
    public User getLoggedInUser(){
        String LoggedInUserEmail = authService.getLoggedInUserEmail();
        return userService.findUserByEmail(LoggedInUserEmail);
    }
    @PutMapping("/address")
    public User updateAddress(@RequestParam String address) {
        String loggedInUserEmail = authService.getLoggedInUserEmail();
        User loggedInUser = userService.findUserByEmail(loggedInUserEmail);
        loggedInUser.setAddress(address);
        return userService.updateAddress(loggedInUser);
    }
    @PutMapping("/phoneno")
    public User updatePhoneno(@RequestParam String phoneno) {
        String loggedInUserEmail = authService.getLoggedInUserEmail();
        User loggedInUser = userService.findUserByEmail(loggedInUserEmail);
        loggedInUser.setPhoneno(phoneno);
        return userService.updatePhoneno(loggedInUser);
    }

    @PutMapping("/profilepic")
    public User updateProfilepic(@RequestParam String profilepic) {
        String loggedInUserEmail = authService.getLoggedInUserEmail();
        User loggedInUser = userService.findUserByEmail(loggedInUserEmail);
        loggedInUser.setProfilepic(profilepic);
        return userService.updateProfilepic(loggedInUser);

    }

}
