package se.kth.sda.ta.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository repository;

    public List<Assignment> getAll() {
        return repository.findAll();
    }

    public Optional<Assignment> getById(Long id) {
        return repository.findById(id);
    }

    public Assignment create(Assignment newAssignment) {
        return repository.save(newAssignment);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Assignment update(Assignment updateAssignment) {
        return repository.save(updateAssignment);
    }
}
