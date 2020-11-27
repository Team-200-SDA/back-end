package se.kth.sda.ta.privatemessage.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "messages")
public class PrivateMessage {

    @Id
    private String id;
    private String message;
    private String sender;
    private String receiver;
    private String channelId;
    private boolean senderSubbed;
    private boolean receiverSubbed;

    public PrivateMessage(String id, String message, String sender, String receiver, String channelId, boolean senderSubbed, boolean receiverSubbed) {
        this.id = id;
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
        this.channelId = channelId;
        this.senderSubbed = senderSubbed;
        this.receiverSubbed = receiverSubbed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public boolean isSenderSubbed() {
        return senderSubbed;
    }

    public void setSenderSubbed(boolean senderSubbed) {
        this.senderSubbed = senderSubbed;
    }

    public boolean isReceiverSubbed() {
        return receiverSubbed;
    }

    public void setReceiverSubbed(boolean receiverSubbed) {
        this.receiverSubbed = receiverSubbed;
    }
}
