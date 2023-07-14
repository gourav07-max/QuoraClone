package com.example.BusinessProfile.repository;

import com.example.BusinessProfile.entity.BusinessLoginEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessLoginRepository extends MongoRepository<BusinessLoginEntity,String> {

    List<BusinessLoginEntity> findByEmail(String email);

}
