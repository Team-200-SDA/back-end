package se.kth.sda.ta.subject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda.ta.subject.model.Subject;
import se.kth.sda.ta.subject.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAll(){
       return subjectRepository.findAll();
    }

    public Optional<Subject> getById(Long id){
        return subjectRepository.findById(id);
    }

    public Subject create(Subject newSubject) {
        return subjectRepository.save(newSubject);
    }

    public Subject update(Subject updatedSubject) {
        return subjectRepository.save(updatedSubject);
    }

    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }
}
