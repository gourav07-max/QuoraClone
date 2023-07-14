package com.example.BusinessProfile.repository;

import com.example.BusinessProfile.entity.BusinessEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends MongoRepository<BusinessEntity,String> {

    List<BusinessEntity> findByName(String name);
}
