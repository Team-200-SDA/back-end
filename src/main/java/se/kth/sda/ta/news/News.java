package se.kth.sda.ta.news;

import javax.persistence.*;

@Entity
@Table
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private String image;

    public News() {
    }

    public News(Long id, String title, String body, String image) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.image = image;
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

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }
}
