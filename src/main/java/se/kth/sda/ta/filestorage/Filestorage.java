package se.kth.sda.ta.filestorage;

import se.kth.sda.ta.user.User;

import javax.persistence.*;

/**
 * This class is a model for File storage entity
 * It contains fields for files stored by user
 * and it contains methods to get and set file details
 * This Filestorage table has relationship with User table */

@Entity
@Table
public class Filestorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String link;
    private String publicId;
    private String type;

    @ManyToOne
    private User user;

    public Filestorage(Long id, String fileName, String link, String publicId, String type, User user) {
        this.id = id;
        this.fileName = fileName;
        this.link = link;
        this.publicId = publicId;
        this.type = type;
        this.user = user;
    }

    public Filestorage() {
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

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String adminKey) {
        this.publicId = adminKey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
