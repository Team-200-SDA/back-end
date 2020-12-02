package se.kth.sda.ta.assignment;

import se.kth.sda.ta.user.User;

import javax.persistence.*;

@Entity
@Table
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String link;

    @ManyToOne
    private User user;

    public Assignment() {
    }

    public Assignment(Long id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
