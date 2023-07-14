package com.example.QuoraUserProfile.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "FollowRequest")
public class FollowRequestEntity {


    @Id
    private String id;
    private String userId;
    private List<String> requests;


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

    public List<String> getRequests() {
        return requests;
    }

    public void setRequests(List<String> requests) {
        this.requests = requests;
    }

    public FollowRequestEntity(){}

}
