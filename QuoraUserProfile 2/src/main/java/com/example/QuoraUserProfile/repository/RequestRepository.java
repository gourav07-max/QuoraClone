package com.example.QuoraUserProfile.repository;

import com.example.QuoraUserProfile.entities.FollowRequestEntity;
import com.example.QuoraUserProfile.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepository extends MongoRepository<FollowRequestEntity, String> {
    Optional<FollowRequestEntity> findByuserId(String id);

}
