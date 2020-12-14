package se.kth.sda.ta.filestorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda.ta.user.User;

import java.util.List;
import java.util.Optional;

/**
 * This class is a Service for file storage entity
 * It contains methods to get and delete files from filestorage repository
 * and stores files to filestorage repository */

@Service
public class FilestorageService {

    private final FilestorageRepo repository;

    @Autowired
    public FilestorageService(FilestorageRepo repository) {
        this.repository = repository;
    }

    public List<Filestorage> getAll() {
        return repository.findAll();
    }

    public List<Filestorage> findAllByUser(User user){
        return repository.findAllByUser(user);
    }

    public Optional<Filestorage> getById(Long id) {
        return repository.findById(id);
    }

    public Filestorage create(Filestorage newFile) {
        return repository.save(newFile);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Filestorage update(Filestorage updateFile) {
        return repository.save(updateFile);
    }
}

