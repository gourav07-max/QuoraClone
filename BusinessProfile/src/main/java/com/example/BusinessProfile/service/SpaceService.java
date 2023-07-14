package com.example.BusinessProfile.service;
import com.example.BusinessProfile.dto.Space;


import java.util.List;

public interface SpaceService {
    void add(Space space);
    List<Space> get();
}
