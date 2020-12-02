package se.kth.sda.ta.filestorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilestorageService {
    @Autowired
    private FilestorageRepo repository;

    public List<Filestorage> getAll() {
        return repository.findAll();
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

