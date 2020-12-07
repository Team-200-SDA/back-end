package se.kth.sda.ta.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.kth.sda.ta.auth.AuthService;
import se.kth.sda.ta.user.User;
import se.kth.sda.ta.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/lectures")
public class LectureController {

    private final LectureService lectureService;
    private final UserService userService;
    private final AuthService authService;

    @Autowired
    public LectureController(LectureService lectureService, UserService userService, AuthService authService) {
        this.lectureService = lectureService;
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("")
    public List<Lecture> getAll() {
        return lectureService.getAll();
    }
    @GetMapping("/{id}")
    public Lecture getById(@PathVariable Long id) {
        return lectureService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping("")
    public Lecture create(@RequestBody Lecture newLecture) {
        User loggedInUser = userService.findUserByEmail(authService.getLoggedInUserEmail());
        newLecture.setUser(loggedInUser);
        return lectureService.create(newLecture);
    }
    @PutMapping("")
    public Lecture update(@RequestBody Lecture updateLecture) {
        return lectureService.update(updateLecture);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lectureService.delete(id);
    }
}
