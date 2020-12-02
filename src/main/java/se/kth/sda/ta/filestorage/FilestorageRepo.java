package se.kth.sda.ta.filestorage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilestorageRepo extends JpaRepository<Filestorage, Long> {

}
