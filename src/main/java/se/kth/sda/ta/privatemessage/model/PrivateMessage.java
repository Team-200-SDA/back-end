package se.kth.sda.ta.privatemessage.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "messages")
public class PrivateMessage {

    @Id
    private String id;
    private String content;
    private String senderName;
    private String senderEmail;
    private String receiverName;
    private String receiverEmail;
    private String date;
    private String author;
    private boolean subscribed;

    public PrivateMessage(String id, String content, String senderName, String senderEmail, String receiverName, String receiverEmail, String date, String author, boolean subscribed) {
        this.id = id;
        this.content = content;
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.receiverName = receiverName;
        this.receiverEmail = receiverEmail;
        this.date = date;
        this.author = author;
        this.subscribed = subscribed;
    }

    public PrivateMessage() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    // To string for debugging
    @Override
    public String toString() {
        return "PrivateMessage{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", senderName='" + senderName + '\'' +
                ", senderEmail='" + senderEmail + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverEmail='" + receiverEmail + '\'' +
                ", date='" + date + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

