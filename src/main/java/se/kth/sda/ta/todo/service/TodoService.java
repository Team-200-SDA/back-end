package se.kth.sda.ta.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda.ta.todo.model.Todo;
import se.kth.sda.ta.todo.repository.TodoRepository;
import se.kth.sda.ta.user.User;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    @Autowired
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> findAllByUser(User user){
        return repository.findAllByUser(user);
    }

    public Todo create(Todo todo) {
        return repository.save(todo);
    }

    public Todo update(Todo todo) {
        return repository.save(todo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
