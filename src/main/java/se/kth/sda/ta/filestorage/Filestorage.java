package se.kth.sda.ta.filestorage;

import javax.persistence.*;

@Entity
@Table
public class Filestorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String link;


    public Filestorage() {
    }

    public Filestorage(Long id, String fileName, String link) {
        this.id = id;
        this.fileName = fileName;
        this.link = link;
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
