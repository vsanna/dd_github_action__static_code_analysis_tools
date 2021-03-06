package dev.ishikawa.sca.sample.domains.entities;

import lombok.Builder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@Entity
@Table(name = "messages", schema = "sampleapp", catalog = "")
public class MessageEntity {
    private Long id;
    private String body;
    private Long senderId;
    private Long receiverId;
    private LocalDateTime sentAt;
    private String encryptedId;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "body", nullable = false, length = 1024)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "sender_id", nullable = false)
    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    @Basic
    @Column(name = "receiver_id", nullable = false)
    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    @Basic
    @Column(name = "sent_at", nullable = true)
    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, senderId, receiverId, sentAt);
    }

    @Basic
    @Column(name = "encrypted_id", nullable = false)
    public String getEncryptedId() {
        return encryptedId;
    }

    public void setEncryptedId(String encryptedId) {
        this.encryptedId = encryptedId;
    }
}
