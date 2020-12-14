package se.kth.sda.ta.filestorage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.kth.sda.ta.user.User;

import java.util.List;

/** This interface is a Repository which gets and deletes files
 * from the database (file storage table) by file id and
 * stores files to database (file storage table)  */

@Repository
public interface FilestorageRepo extends JpaRepository<Filestorage, Long> {
    List<Filestorage> findAllByUser(User user);
}
