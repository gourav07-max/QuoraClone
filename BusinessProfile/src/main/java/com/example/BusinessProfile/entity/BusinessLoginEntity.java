package com.example.BusinessProfile.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "BusinessLogin")
public class BusinessLoginEntity {

//    @Id
//    private String id;
    private String username;
    private String email;
    private String password;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BusinessLoginEntity(){}



}
