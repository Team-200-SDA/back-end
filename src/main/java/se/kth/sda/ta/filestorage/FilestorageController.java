package se.kth.sda.ta.filestorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.kth.sda.ta.auth.AuthService;
import se.kth.sda.ta.user.User;
import se.kth.sda.ta.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/filestorage")
public class FilestorageController {

    private final FilestorageService filestorageService;
    private final UserService userService;
    private final AuthService authService;

    @Autowired
    public FilestorageController(FilestorageService filestorageService, UserService userService, AuthService authService) {
        this.filestorageService = filestorageService;
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("")
    public List<Filestorage> getAll() {
        User loggedInUser = userService.findUserByEmail(authService.getLoggedInUserEmail());
        return filestorageService.findAllByUser(loggedInUser);
    }

    @GetMapping("/{id}")
    public Filestorage getById(@PathVariable Long id) {
        return filestorageService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public Filestorage create(@RequestBody Filestorage newFile) {
        String loggedInUserEmail = authService.getLoggedInUserEmail();
        User loggedInUser = userService.findUserByEmail(loggedInUserEmail);
        newFile.setUser(loggedInUser);
        return filestorageService.create(newFile);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        filestorageService.delete(id);
    }

}
