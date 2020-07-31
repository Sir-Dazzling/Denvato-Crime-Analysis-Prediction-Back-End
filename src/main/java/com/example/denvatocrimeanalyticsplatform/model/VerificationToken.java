package com.example.denvatocrimeanalyticsplatform.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class VerificationToken
{
    //Defining the fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tokenId;

    private String verificationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public VerificationToken()
    {
        //Default Constructor
    }

    //Defining the constructor(s)
    public VerificationToken(User user)
    {
        this.user = user;
        createdDate = new Date();
        verificationToken = UUID.randomUUID().toString();
    }

    //Defining the getters/setters

    public long getTokenId() {
        return tokenId;
    }

    public void setTokenId(long tokenId) {
        this.tokenId = tokenId;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}