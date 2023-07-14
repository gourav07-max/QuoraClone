package com.example.BusinessProfile.service;

import com.example.BusinessProfile.dto.Space;
import com.example.BusinessProfile.entity.SpaceEntity;
import com.example.BusinessProfile.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SpaceServiceimp implements SpaceService{

    @Autowired
    SpaceRepository spaceRepository;


    @Override
    public void add(Space space) {
        List<SpaceEntity> spaceEntities=spaceRepository.findByName(space.getName());
        SpaceEntity spaceEntity=new SpaceEntity();

            if(spaceEntities.size()==0){
                spaceEntity.setId(space.getId());
                spaceEntity.setModeratorid(space.getModeratorid());
                spaceEntity.setName(space.getName());
                spaceRepository.save(spaceEntity);
            }
    }

    @Override
    public List<Space> get() {
        Iterable<SpaceEntity> spaceEntities=spaceRepository.findAll();
        List<Space> spaceList=new ArrayList<>();
        for(SpaceEntity spaceEntity:spaceEntities){
            Space space=new Space(spaceEntity.getId(),spaceEntity.getModeratorid(),spaceEntity.getName());
            spaceList.add(space);
        }
        return spaceList;
    }
}
