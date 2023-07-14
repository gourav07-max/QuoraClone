package com.example.BusinessProfile.controller;

import com.example.BusinessProfile.dto.Business;
import com.example.BusinessProfile.dto.BusinessLogin;
import com.example.BusinessProfile.dto.Space;
import com.example.BusinessProfile.response.Response;
import com.example.BusinessProfile.service.BusinessLoginService;
import com.example.BusinessProfile.service.BusinessService;
import com.example.BusinessProfile.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/business")
@Valid
public class BusinessController {
    @Autowired
    BusinessService businessService;

    @Autowired
    SpaceService spaceService;

    @Autowired
    BusinessLoginService businessLoginService;


    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/all-business")
    public List<Business> get(){
       return businessService.get();
    }


    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping (produces = "application/json")
    public void add(@RequestBody  Business business){
        businessService.add(business);
    }

    @PutMapping("/update-ads")
    public void updateads(@RequestParam String id , @RequestParam List<String> ads){
        businessService.updateAds(id,ads);
    }

    @PutMapping("/update-moderator")
    public void updatemoderator(@RequestParam String id,@RequestParam String moderator){
        businessService.updateModerator(id,moderator);
    }
    @PutMapping("/update-following")
    public void updateFollowing(@RequestParam String id , @RequestParam List<String> followId){
        businessService.addFollowing(id,followId);
    }

    @PutMapping("/update-followers")
    public void UpdateFollowers(@RequestParam String id,@RequestParam List<String> requestId) {
        businessService.addFollowers(id, requestId);
    }

    @PostMapping("/add-space")
    public void addspace(@RequestBody Space space){
        spaceService.add(space);
    }

    @GetMapping("/all-spaces")
    public List<Space> getspaces(){
        return spaceService.get();
    }


    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping(path="/login" ,produces = "application/json")
    public Response<Boolean> businesslogin(@RequestParam String email, String password){

        Boolean isTrue = businessLoginService.login(email,password);
        if(isTrue){

            return new Response<>(true);

        }else {
            return new Response<>(6001 , "unable to login");
        }
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping(path="/signup" ,produces = "application/json")
    public Response<Boolean> usersignup(@RequestBody @Valid BusinessLogin businessLogin){


        Boolean isTrue = businessLoginService.signup(businessLogin);
        if(isTrue){
            return new Response<>(true);
        }else {
            return new Response<>(6001 , "unable to signup");
        }

    }
}
