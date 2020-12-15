package se.kth.sda.ta.forum.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/** This interface is a Repository which gets the
 * comments by post id, updates and deletes comments
 * from the database by comment id.
 */
@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(Long postId);
}
