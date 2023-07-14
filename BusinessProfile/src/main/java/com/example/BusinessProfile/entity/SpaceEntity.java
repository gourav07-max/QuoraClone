package com.example.BusinessProfile.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "Space")
public class SpaceEntity {

    @Id
    private String id;
    private String moderatorid;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModeratorid() {
        return moderatorid;
    }

    public void setModeratorid(String moderatorid) {
        this.moderatorid = moderatorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpaceEntity(){}
}
