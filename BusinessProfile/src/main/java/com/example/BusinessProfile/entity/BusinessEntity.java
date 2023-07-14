package com.example.BusinessProfile.entity;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.*;
import java.util.List;

@Document(collection = "BusinessProfile")
public class BusinessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable =false)
    private String id;


    private String name;
    private List<String> adpreference;
    private String moderator;
    private List<String> followers;
    private List<String> following;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public BusinessEntity(){}



}
