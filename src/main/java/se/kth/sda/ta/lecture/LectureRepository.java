package se.kth.sda.ta.lecture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.kth.sda.ta.subject.model.Subject;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findAllBySubject_Id(Long id);

}
