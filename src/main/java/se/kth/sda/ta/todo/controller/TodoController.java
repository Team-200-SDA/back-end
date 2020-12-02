package se.kth.sda.ta.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.kth.sda.ta.auth.AuthService;
import se.kth.sda.ta.todo.model.Todo;
import se.kth.sda.ta.todo.service.TodoService;
import se.kth.sda.ta.user.User;
import se.kth.sda.ta.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;
    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public TodoController(TodoService todoService, AuthService authService, UserService userService) {
        this.todoService = todoService;
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping("")
    public List<Todo> getTodos() {
        User loggedInUser = userService.findUserByEmail(authService.getLoggedInUserEmail());
        return todoService.findAllByUser(loggedInUser);
    }

    @PostMapping("")
    public Todo create(@RequestBody Todo newTodo) {
        User loggedInUser = userService.findUserByEmail(authService.getLoggedInUserEmail());
        newTodo.setUser(loggedInUser);
        return todoService.create(newTodo);
    }

    @PutMapping("")
    public Todo update(@RequestBody Todo updatedTodo) {
        return todoService.update(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        todoService.delete(id);
    }
}
