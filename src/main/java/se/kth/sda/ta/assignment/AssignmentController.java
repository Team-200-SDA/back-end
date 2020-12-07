package se.kth.sda.ta.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.kth.sda.ta.auth.AuthService;
import se.kth.sda.ta.user.User;
import se.kth.sda.ta.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;
    private final UserService userService;
    private final AuthService authService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService, UserService userService, AuthService authService) {
        this.assignmentService = assignmentService;
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("")
    public List<Assignment> getAll() {
        User loggedInUser = userService.findUserByEmail(authService.getLoggedInUserEmail());
        if (loggedInUser.getRole().equalsIgnoreCase("student")) {
            return assignmentService.findAllByUser(loggedInUser);
        }
        return null;
    }

    @GetMapping("/{id}")
    public Assignment getById(@PathVariable Long id) {
        return assignmentService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/teacher")
    public List<Assignment> getTeacherAssignments(){
        return assignmentService.findByUserRole("teacher");
    }

    // If you are a teacher, return ALL of the student submissions.
    @GetMapping("/students")
    public List<Assignment> getStudentAssignments(){
        User loggedInUser = userService.findUserByEmail(authService.getLoggedInUserEmail());
        if (loggedInUser.getRole().equalsIgnoreCase("teacher")){
            return assignmentService.findByUserRole("student");
        }
        return null;
    }

    // Adds the user to the assignment on creation.
    @PostMapping("")
    public Assignment create(@RequestBody Assignment newAssignment) {
        User loggedInUser = userService.findUserByEmail(authService.getLoggedInUserEmail());
        newAssignment.setUser(loggedInUser);
        return assignmentService.create(newAssignment);
    }
    @PutMapping("")
    public Assignment update(@RequestBody Assignment updateAssignment) {
        return assignmentService.update(updateAssignment);
    }

    // Anyone can delete for now. Will do "role" safety check after FE implementation.
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        assignmentService.delete(id);
    }
}
