package com.a407.back.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Table(name = "NOTIFICATION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id", updatable = false)
    private Long notificationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room roomId;

    @Column(name = "send_id", nullable = false)
    private Long sendId;

    @Column(name = "receive_id", nullable = false)
    private Long receiveId;

    @ColumnDefault("false")
    @Column(name = "is_read", nullable = false)
    private Boolean isRead;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @ColumnDefault("standby")
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public Notification(Room roomId, Long sendId, Long receiveId, Boolean isRead,
        Timestamp createdAt, Type type, Status status) {
        this.roomId = roomId;
        this.sendId = sendId;
        this.receiveId = receiveId;
        this.isRead = isRead;
        this.createdAt = createdAt;
        this.type = type;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Notification{" +
            "notificationId=" + notificationId +
            ", sendId=" + sendId +
            ", receiveId=" + receiveId +
            ", roomId=" + roomId +
            ", isRead=" + isRead +
            ", createdAt=" + createdAt +
            ", type=" + type +
            ", status=" + status +
            '}';
    }

    public enum Type {
        USER, ZIPSA
    }

    public enum Status {
        STANDBY, ACCEPT, REJECT, CLOSE
    }
}
