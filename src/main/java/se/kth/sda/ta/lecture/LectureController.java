package se.kth.sda.ta.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/lectures")
public class LectureController {
    @Autowired
    private LectureService lectureService;

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
