package com.example.BusinessProfile.service;

import com.example.BusinessProfile.dto.BusinessLogin;
import com.example.BusinessProfile.entity.BusinessLoginEntity;
import com.example.BusinessProfile.repository.BusinessLoginRepository;
import com.example.BusinessProfile.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessLoginServiceimp implements BusinessLoginService {

    @Autowired
    BusinessLoginRepository businessLoginRepository;


    @Override
    public boolean login(String email, String password) {
        Iterable<BusinessLoginEntity> businessLoginEntities=businessLoginRepository.findAll();
        for(BusinessLoginEntity businessLoginEntity:businessLoginEntities){
            if (businessLoginEntity.getPassword().equals(password) && businessLoginEntity.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean signup(BusinessLogin businessLogin) {

        BusinessLoginEntity businessLoginEntity = new BusinessLoginEntity();
        businessLoginEntity.setUsername(businessLogin.getUsername());
        businessLoginEntity.setEmail(businessLogin.getEmail());
        businessLoginEntity.setPassword(businessLogin.getPassword());


        List<BusinessLoginEntity> businessLoginEntities = businessLoginRepository.findByEmail(businessLogin.getEmail());

        if (businessLoginEntities.size() == 0) {
//            if (businessLoginEntity.getPassword().equals(userEntity.getConfirmpassword())) {
                businessLoginRepository.save(businessLoginEntity);
                return true;

        }
        return false;

    }
}
