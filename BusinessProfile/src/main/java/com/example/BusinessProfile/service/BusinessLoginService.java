package com.example.BusinessProfile.service;

import com.example.BusinessProfile.dto.BusinessLogin;

public interface BusinessLoginService {
    boolean login(String email,String password);
    boolean signup(BusinessLogin businessLogin);

}
