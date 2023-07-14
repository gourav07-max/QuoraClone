package com.example.BusinessProfile.service;

import com.example.BusinessProfile.dto.Business;
import com.example.BusinessProfile.entity.BusinessEntity;
import com.example.BusinessProfile.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusinessServiceimp implements BusinessService {

    @Autowired
    BusinessRepository businessRepository;

    @Override
    public void add(Business business) {
        List<BusinessEntity> businessEntities =businessRepository.findByName(business.getName());
        BusinessEntity businessEntity=new BusinessEntity();
        if(businessEntities.size()==0) {
            businessEntity.setAdpreference(business.getAdpreference());
            businessEntity.setModerator(business.getModerator());
            businessEntity.setName(business.getName());
            businessEntity.setFollowers(business.getFollowers());
            businessEntity.setFollowing(business.getFollowing());
            businessRepository.save(businessEntity);
        }
    }

    @Override
    public List<Business> get() {
        Iterable<BusinessEntity> businessEntities=businessRepository.findAll();
        List<Business> businessList=new ArrayList<>();

        for(BusinessEntity businessEntity:businessEntities){
            Business business=new Business(businessEntity.getName(),businessEntity.getAdpreference(),businessEntity.getModerator(),businessEntity.getId(),businessEntity.getFollowers(),businessEntity.getFollowing());
            businessList.add(business);

        }
        return businessList;
    }

    @Override
    public void updateAds(String id, List<String> ads) {
        Optional<BusinessEntity> businessEntity=businessRepository.findById(id);
        if(businessEntity.isPresent()){
            BusinessEntity businessEntity1 = businessEntity.get();
            List<String> advertize = businessEntity1.getAdpreference();

            for(String i : ads){
                advertize.add(i);
            }
            businessEntity1.setAdpreference(advertize);
            businessRepository.save(businessEntity1);
        }

        //by passing in requestbody
    }

    @Override
    public void updateModerator(String id, String moderator) {
        Optional<BusinessEntity> businessEntity=businessRepository.findById(id);
        System.out.println(businessEntity.isPresent());
        if(businessEntity.isPresent()){
            businessEntity.get().setModerator(moderator);
        }
        businessRepository.save(businessEntity.get());

    }

    @Override
    public void addFollowers(String id, List<String> requestId) {
        Optional<BusinessEntity> businessEntity=businessRepository.findById(id);
        if(businessEntity.isPresent()){
//            BusinessEntity businessEntity1 = businessEntity.get();
            List<String> followAccept = businessEntity.get().getFollowers();

            for(String follow : requestId){
                followAccept.add(follow);
            }
            businessEntity.get().setFollowers(followAccept);
            businessRepository.save(businessEntity.get());
        }

    }

    @Override
    public void addFollowing(String id, List<String> followId){

        Optional<BusinessEntity> businessEntity=businessRepository.findById(id);
        if(businessEntity.isPresent()){
            List<String> followRequest = businessEntity.get().getFollowing();

            for(String follow : followId){
                followRequest.add(follow);
            }
            businessEntity.get().setFollowing(followRequest);
            businessRepository.save(businessEntity.get());
        }


    }
    //update adpreference
    // create space
    // changeModerator


}
