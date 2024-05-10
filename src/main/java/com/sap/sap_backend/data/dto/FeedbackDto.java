package com.sap.sap_backend.data.dto;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;

@Table("feedback_details")
public class FeedbackDto {
    @PrimaryKey
    @Column(value = "username")
    private String username;
    @Column(value="phonenumber")
    private String phoneNumber;
    @Column(value = "email")
    private String email;
    private String feedback;
    private Timestamp updt_ts;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Timestamp getUpdt_ts() {
        return updt_ts;
    }

    public void setUpdt_ts(Timestamp updt_ts) {
        this.updt_ts = updt_ts;
    }
}
