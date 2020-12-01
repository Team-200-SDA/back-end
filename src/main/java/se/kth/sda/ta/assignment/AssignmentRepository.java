package se.kth.sda.ta.assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.kth.sda.ta.user.User;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findAllByUser(User user);
    List<Assignment> findAllByUser_Role(String role);

}
