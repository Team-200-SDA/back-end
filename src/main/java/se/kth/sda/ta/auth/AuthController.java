package se.kth.sda.ta.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import se.kth.sda.ta.user.User;
import se.kth.sda.ta.user.UserService;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        user.setRole("student");
        userService.register(user);
        String token = authService.createAuthToken(user.getEmail());
        AuthResponse authResponse = new AuthResponse(token);
        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/register/{code}")
    public ResponseEntity<?> registerTeacher(@RequestBody User user, @PathVariable Long code) {
        if (code == 83224) {
            user.setRole("teacher");
        }
        userService.register(user);
        String token = authService.createAuthToken(user.getEmail());
        AuthResponse authResponse = new AuthResponse(token);
        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) {
        try {
            String token = authService.authenticate(authRequest.getEmail(), authRequest.getPassword());
            AuthResponse authResponse = new AuthResponse(token);

            return new ResponseEntity<>(authResponse, HttpStatus.OK);
        } catch (AuthenticationException authenticationException) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
