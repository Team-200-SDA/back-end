package se.kth.sda.ta.filestorage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.kth.sda.ta.user.User;

import java.util.List;

@Repository
public interface FilestorageRepo extends JpaRepository<Filestorage, Long> {
    List<Filestorage> findAllByUser(User user);
}
