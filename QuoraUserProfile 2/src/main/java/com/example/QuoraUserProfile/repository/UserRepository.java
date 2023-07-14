package com.example.QuoraUserProfile.repository;

import com.example.QuoraUserProfile.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

    List<UserEntity> findByuserName(String name);
    Optional<UserEntity> findByuserId(String id);

}
