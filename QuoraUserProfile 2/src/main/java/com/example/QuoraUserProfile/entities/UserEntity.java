package com.example.QuoraUserProfile.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "UserProfile")
public class UserEntity implements Serializable {

    @Id
    private String id;
    private String userId;
    private String userName;
    private List<String> follwingList;
    private List<String> followersList;
    private String accountType;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UserEntity(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getFollwingList() {
        return follwingList;
    }

    public void setFollwingList(List<String> follwingList) {
        this.follwingList = follwingList;
    }

    public List<String> getFollowersList() {
        return followersList;
    }

    public void setFollowersList(List<String> followersList) {
        this.followersList = followersList;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}