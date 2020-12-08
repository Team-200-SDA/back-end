package se.kth.sda.ta.lecture;

import se.kth.sda.ta.subject.model.Subject;

import javax.persistence.*;

@Entity
@Table(name = "lectures")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String link;
    private String publicId;
    private String type;


    @ManyToOne
    private Subject subject;

    public Lecture(Long id, String fileName, String link, String publicId, String type, Subject subject) {
        this.id = id;
        this.fileName = fileName;
        this.link = link;
        this.publicId = publicId;
        this.type = type;
        this.subject = subject;
    }

    public Lecture() {
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
