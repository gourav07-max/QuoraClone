package com.example.BusinessProfile.service;

import com.example.BusinessProfile.dto.Business;
import com.example.BusinessProfile.entity.BusinessEntity;

import java.util.List;


public interface BusinessService {

    void add(Business business);
    List<Business> get();
    void updateAds(String id, List<String> ads);
    void updateModerator(String id,String moderator);
    void addFollowing(String id,List<String> followId);
    void addFollowers(String id,List<String> requestId);

}
