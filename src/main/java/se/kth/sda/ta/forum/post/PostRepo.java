package se.kth.sda.ta.forum.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** This interface is a Repository which gets, updates and deletes posts
 * from the database by post id.
 */
@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

}
