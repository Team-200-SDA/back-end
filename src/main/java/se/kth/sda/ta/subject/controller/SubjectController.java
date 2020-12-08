package se.kth.sda.ta.subject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.kth.sda.ta.subject.model.Subject;
import se.kth.sda.ta.subject.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("")
    public List<Subject> getAll() {
        return subjectService.getAll();
    }

    @GetMapping("/{id}")
    public Subject getById(@PathVariable Long id) {
        return subjectService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public Subject create(@RequestBody Subject newSubject) {
        return subjectService.create(newSubject);
    }

    @PutMapping("")
    public Subject update(@RequestBody Subject updatedSubject) {
        return subjectService.update(updatedSubject);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        subjectService.delete(id);
    }

}
