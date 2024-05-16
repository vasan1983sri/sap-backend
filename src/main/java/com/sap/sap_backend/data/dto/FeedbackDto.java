package com.sap.sap_backend.data.dto;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;

@Table("feedback_details")
public class FeedbackDto {
    @PrimaryKey
    @Column(value="id")
    private Integer id;

    @Column(value = "username")
    private String flName;
    @Column(value="phonenumber")
    private String phoneNumber;
    @Column(value = "email")
    private String email;
    @Column(value = "feedback")
    private String fbMessage;
    @Column(value = "updt_ts")
    private Timestamp updt_ts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlName() {
        return flName;
    }

    public void setFlName(String flName) {
        this.flName = flName;
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

    public String getFbMessage() {
        return fbMessage;
    }

    public void setFbMessage(String fbMessage) {
        this.fbMessage = fbMessage;
    }

    public Timestamp getUpdt_ts() {
        return updt_ts;
    }

    public void setUpdt_ts(Timestamp updt_ts) {
        this.updt_ts = updt_ts;
    }
}
