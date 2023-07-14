package com.example.BusinessProfile.dto;

public class Space {
    private String id;
    private String moderatorid;
    private String name;

    public Space(String id, String moderatorid, String name) {
        this.id = id;
        this.moderatorid = moderatorid;
        this.name = name;
    }

    public String getModeratorid() {
        return moderatorid;
    }

    public void setModeratorid(String moderatorid) {
        this.moderatorid = moderatorid;
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
    public Space(){}
}
