package se.kth.sda.ta.forum.comment;

import se.kth.sda.ta.forum.post.Post;
import se.kth.sda.ta.user.User;

import javax.persistence.*;


@Entity
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    public Comment() {}

    public Comment (Long id, String body, User user, Post post) {
        this.id = id;
        this.body = body;
        this.user = user;
        this.post = post;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
