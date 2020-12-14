package se.kth.sda.ta.subject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import se.kth.sda.ta.lecture.Lecture;

import javax.persistence.*;
import java.util.List;

/**
 * Subject entity is used for creating Subject by
 * teacher under which its lectures will be created
 */
@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "link")
    private String link;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.REMOVE)
    private List<Lecture> lectures;

    public Subject(Long id, String name, String description, String link) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.link = link;
    }

    public Subject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}
