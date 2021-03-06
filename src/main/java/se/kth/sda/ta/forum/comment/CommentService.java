package se.kth.sda.ta.forum.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * This class is a Service for Comment entity
 * It contains methods to get and delete files from Comment repository
 * and stores comments to Comment repository */
@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    public List<Comment> getAll(){
        return commentRepo.findAll();
    }

    public Optional<Comment> getById(Long id){
        return commentRepo.findById(id);
    }

    public Comment create(Comment newComment) {
        return commentRepo.save(newComment);

    }

    public Comment update(Comment updatedComment) {
        return commentRepo.save(updatedComment);

    }

    public void delete(Long id) {
        commentRepo.deleteById(id);

    }

    public List<Comment> getAllByPostId(Long postId) {
        return commentRepo.findAllByPostId(postId);

    }
}

