package com.example.QuoraUserProfile.services;

import com.example.QuoraUserProfile.dto.QuestionDto;
import com.example.QuoraUserProfile.dto.UserProfile;
import com.example.QuoraUserProfile.entities.FollowRequestEntity;
import com.example.QuoraUserProfile.entities.UserEntity;

import java.util.List;


public interface UserService {


    public UserEntity getUserbyId(String id);
    public List<UserProfile> getAllusers();
    public boolean addFolower(String userid,String follwerid);
    public boolean addFolowing(String userid,String follwingid);
    public boolean addUser(UserProfile userProfile);
    public void sendRequest(String userId, String requestId);
    public List<QuestionDto> feed(String id);
    public boolean deleteUser(String id);
    public FollowRequestEntity getAllRequests(String userId);



}
