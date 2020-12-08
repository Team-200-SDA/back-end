package se.kth.sda.ta.subject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.kth.sda.ta.subject.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
