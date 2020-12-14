package se.kth.sda.ta.assignment;

import se.kth.sda.ta.user.User;

import javax.persistence.*;

@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String link;
    private String publicId;
    private String type;
    private String dueDate;

    @ManyToOne
    private User user;

    public Assignment(Long id, String fileName, String link, String publicId, String type, String dueDate, User user) {
        this.id = id;
        this.fileName = fileName;
        this.link = link;
        this.publicId = publicId;
        this.type = type;
        this.dueDate = dueDate;
        this.user = user;
    }

    public Assignment() {
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

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}