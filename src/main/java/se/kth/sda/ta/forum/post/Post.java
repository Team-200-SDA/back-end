package se.kth.sda.ta.forum.post;

import se.kth.sda.ta.user.User;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @ElementCollection
    private Set<String> likedUsers;

    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(Long id, String title, String body, User user, Set<String> likedUsers) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.likedUsers = likedUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Set<String> getLikedUsers() {
        return likedUsers;
    }

    public void setLikedUsers(Set<String> likedUsers) {
        this.likedUsers = likedUsers;
    }
}
