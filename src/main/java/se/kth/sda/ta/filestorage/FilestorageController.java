package se.kth.sda.ta.filestorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.kth.sda.ta.assignment.Assignment;
import se.kth.sda.ta.assignment.AssignmentService;

import java.util.List;
@RestController
@RequestMapping("/filestorage")
public class FilestorageController {
        @Autowired
        private FilestorageService filestorageService;

        @GetMapping("")
        public List<Filestorage> getAll() {
            return filestorageService.getAll();
        }
        @GetMapping("/{id}")
        public Filestorage getById(@PathVariable Long id) {
            return filestorageService.getById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }
        @PostMapping("")
        public Filestorage create(@RequestBody Filestorage newFile) {
            return filestorageService.create(newFile);
        }
  /*      @PutMapping("")
        public Filestorage update(@RequestBody Filestorage updateFile) {
            return filestorageService.update(updateFile);
        }*/
        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {filestorageService.delete(id);
        }

}
