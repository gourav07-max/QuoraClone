package com.example.QuoraUserProfile.dto;

import java.io.Serializable;
import java.util.List;

public class UserProfile implements Serializable {

    private String userId;
    private String userName;
    private List<String> follwingList;
    private List<String> followersList;
    private String accountType;
    private String image;






    public UserProfile() {
    }


    public UserProfile(String userId, String userName, List<String> follwingList, List<String> followersList, String accountType, String image) {
        this.userId = userId;
        this.userName = userName;
        this.follwingList = follwingList;
        this.followersList = followersList;
        this.accountType = accountType;
        this.image =image;

    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
