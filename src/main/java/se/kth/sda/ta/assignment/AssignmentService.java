package se.kth.sda.ta.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda.ta.todo.model.Todo;
import se.kth.sda.ta.todo.repository.TodoRepository;
import se.kth.sda.ta.user.User;
import se.kth.sda.ta.user.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository, UserRepository userRepository, TodoRepository todoRepository) {
        this.assignmentRepository = assignmentRepository;
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    public List<Assignment> getAll() {
        return assignmentRepository.findAll();
    }

    public List<Assignment> findAllByUser(User user) {
        return assignmentRepository.findAllByUser(user);
    }

    public List<Assignment> findByUserRole(String role){
        return assignmentRepository.findAllByUser_Role(role);
    }

    public Optional<Assignment> getById(Long id) {
        return assignmentRepository.findById(id);
    }


    public Assignment create(Assignment newAssignment) {
        if (newAssignment.getUser().getRole().equalsIgnoreCase("teacher")){
            addToTodos(newAssignment);
        }
        return assignmentRepository.save(newAssignment);
    }

    public void delete(Long id) {
        assignmentRepository.deleteById(id);
    }

    public Assignment update(Assignment updateAssignment) {
        return assignmentRepository.save(updateAssignment);
    }

    private void addToTodos(Assignment assignment) {
        List<User> userList = userRepository.findAll();
        userList.forEach(user -> {
            todoRepository
                    .save(new Todo(null,
                            assignment.getFileName(),
                            "ASSIGNMENT",
                            false, assignment.getDueDate(),
                            user));
        });
    }
}
