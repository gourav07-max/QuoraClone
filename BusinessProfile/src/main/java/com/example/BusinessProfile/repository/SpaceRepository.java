package com.example.BusinessProfile.repository;

import com.example.BusinessProfile.entity.SpaceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SpaceRepository extends MongoRepository<SpaceEntity,String> {


    List<SpaceEntity> findByName(String name);

}
