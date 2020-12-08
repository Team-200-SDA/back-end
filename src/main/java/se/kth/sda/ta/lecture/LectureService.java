package se.kth.sda.ta.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectureService {
    @Autowired
    private LectureRepository repository;

    public List<Lecture> getAll() {
        return repository.findAll();
    }

    public List<Lecture> getAllBySubjectId(Long id) {
        return repository.findAllBySubject_Id(id);
    }

    public Optional<Lecture> getById(Long id) {
        return repository.findById(id);
    }

    public Lecture create(Lecture newLecture) {
        return repository.save(newLecture);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Lecture update(Lecture updateLecture) {
        return repository.save(updateLecture);
    }
}
