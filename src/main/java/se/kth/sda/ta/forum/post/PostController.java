package se.kth.sda.ta.forum.post;



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
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<Post> getAll() {
        return postService.getAll();
    }


    @GetMapping("/{id}")
    public Post getById(@PathVariable Long id){
        return postService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public Post create(@RequestBody Post newPost){
        newPost.setUser(extractUserFromAuth());
        return postService.create(newPost);
    }

    @PutMapping("")
    public Post update(@RequestBody Post updatedPost){
        //TODO: check if current user is owner of the post
        //compare current user and based on postID user of the post
        updatedPost.setUser(extractUserFromAuth());
        return postService.update(updatedPost);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        postService.delete(id);
    }

    //extracting information about the user from current session (not from front end)
    public User extractUserFromAuth()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        return userService.findUserByEmail(userDetails.getUsername());
    }

}