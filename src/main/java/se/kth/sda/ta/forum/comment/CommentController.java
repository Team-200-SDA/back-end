package se.kth.sda.ta.forum.comment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.kth.sda.ta.user.User;
import se.kth.sda.ta.user.UserService;


import java.util.List;

/**
 * This class executes the HTML requests coming from the user
 * by invoking the methods in CommentService class
 */
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<Comment> getAll(@RequestParam(required = false) Long postId){
        if (postId == null) {
            return commentService.getAll();
        }
        else {
            return commentService.getAllByPostId(postId);
        }
    }


    @GetMapping("/{id}")
    public Comment getById(@PathVariable Long id){
        return commentService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //Receives the new comment and assigns the logged-in user as the user of the comment
    @PostMapping("")
    public Comment create(@RequestBody Comment newComment){
        newComment.setUser(extractUserFromAuth());
        return commentService.create(newComment);
    }

    @PutMapping("")
    public Comment update(@RequestBody Comment updatedComment){
        return commentService.update(updatedComment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }


    public User extractUserFromAuth()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        return  userService.findUserByEmail(userDetails.getUsername());
    }
}
