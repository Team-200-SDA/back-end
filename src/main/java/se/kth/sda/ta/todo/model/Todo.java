package se.kth.sda.ta.todo.model;
import java.util.*;
import se.kth.sda.ta.user.User;
import javax.persistence.*;

//Using JPA entitiy for making relationship to DB
@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "complete")
    private boolean complete;
    @Column(name = "due_date")
    private String dueDate;

    @ManyToOne
    private User user;

    public Todo(Long id, String title, String description, boolean complete, String dueDate, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.complete = complete;
        this.dueDate = dueDate;
        this.user = user;
    }

    public Todo() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
