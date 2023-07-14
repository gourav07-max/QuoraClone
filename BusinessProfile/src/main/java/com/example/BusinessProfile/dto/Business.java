package com.example.BusinessProfile.dto;

import java.util.List;

public class Business {
    private String name;
    private List<String> adpreference;
    private String moderator;
    private String id;
    private List<String> followers;

    public Business(String name, List<String> adpreference, String moderator, String id, List<String> followers, List<String> following) {
        this.name = name;
        this.adpreference = adpreference;
        this.moderator = moderator;
        this.id = id;
        this.followers = followers;
        this.following = following;
    }

    private List<String> following;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAdpreference() {
        return adpreference;
    }

    public void setAdpreference(List<String> adpreference) {
        this.adpreference = adpreference;
    }

    public String getModerator() {
        return moderator;
    }

    public void setModerator(String moderator) {
        this.moderator = moderator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }

    public List<String> getFollowing() {
        return following;
    }

    public void setFollowing(List<String> following) {
        this.following = following;
    }







    public Business(){}




}
