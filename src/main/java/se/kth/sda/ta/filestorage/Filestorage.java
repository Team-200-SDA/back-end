package se.kth.sda.ta.filestorage;

import se.kth.sda.ta.user.User;

import javax.persistence.*;

@Entity
@Table
public class Filestorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String link;

    @ManyToOne
    private User user;

    public Filestorage() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Filestorage(Long id, String fileName, String link, User user) {
        this.id = id;
        this.fileName = fileName;
        this.link = link;
        this.user = user;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
