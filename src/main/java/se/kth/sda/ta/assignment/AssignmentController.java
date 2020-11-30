package se.kth.sda.ta.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("")
    public List<Assignment> getAll() {
        return assignmentService.getAll();
    }
    @GetMapping("/{id}")
    public Assignment getById(@PathVariable Long id) {
        return assignmentService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping("")
    public Assignment create(@RequestBody Assignment newAssignment) {
        return assignmentService.create(newAssignment);
    }
    @PutMapping("")
    public Assignment update(@RequestBody Assignment updateAssignment) {
        return assignmentService.update(updateAssignment);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        assignmentService.delete(id);
    }
}
