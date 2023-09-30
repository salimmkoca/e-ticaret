package com.example.auth.rabbitmq.model;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {
    private String notificationID;
    private Date createdAt;
    private String message;

    public String getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(String notificationID) {
        this.notificationID = notificationID;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationID='" + notificationID + '\'' +
                ", createdAt=" + createdAt +
                ", message='" + message + '\'' +
                '}';
    }
}
