package se.kth.sda.ta.forum.post;

import se.kth.sda.ta.user.User;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Post entity is used for creating posts by
 * the users under the forum page
 */
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    //Holds the usernames of liked users. HashSet doesn't allow duplicate values
    @ElementCollection
    private Set<String> likedUsers = new HashSet<>();

    //Holds the usernames of disliked users. HashSet doesn't allow duplicate values
    @ElementCollection
    private Set<String> disLikedUsers = new HashSet<>();

    //Counts the numbers of likes and dislikes
    private int upVote;

    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(Long id, String title, String body, User user, Set<String> likedUsers, Set<String> disLikedUsers, int upVote) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.likedUsers = likedUsers;
        this.disLikedUsers = disLikedUsers;
        this.upVote = upVote;

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

    public Set<String> getDisLikedUsers() {
        return  disLikedUsers;
    }

    public void setDisLikedUsers(Set<String> disLikedUsers) {
        this.disLikedUsers = disLikedUsers;
    }

    //Returns the total number of likes. It could also return a negative number.
    public int getUpVote() {
        this.upVote = (this.likedUsers.size() - this.disLikedUsers.size());
        return this.upVote;
    }

}
