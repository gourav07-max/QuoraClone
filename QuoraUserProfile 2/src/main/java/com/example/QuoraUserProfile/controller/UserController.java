package com.example.QuoraUserProfile.controller;

import com.example.QuoraUserProfile.Response.ResponseEntity;
import com.example.QuoraUserProfile.dto.QuestionDto;
import com.example.QuoraUserProfile.dto.UserProfile;
import com.example.QuoraUserProfile.entities.FollowRequestEntity;
import com.example.QuoraUserProfile.entities.UserEntity;
import com.example.QuoraUserProfile.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



    @RestController
    @RequestMapping("/userProfile")
    @Valid
    @CrossOrigin(value = "http://localhost:8082")
    public class UserController {
        @Autowired
        UserService userService;

        @CrossOrigin
        @GetMapping("/users")
        public ResponseEntity<List<UserProfile>> getAllusers() {
            List<UserProfile> userProfileList= userService.getAllusers();
            if(userProfileList!=null){

                return new ResponseEntity<>(userProfileList);
            }else{
                return new ResponseEntity<>(400 , "No Users Found");
            }
        }


        @CrossOrigin
        @GetMapping("/requests")
        public ResponseEntity<FollowRequestEntity> getAllRequest(@RequestParam(required = true) String userId) {
            FollowRequestEntity userProfileList= userService.getAllRequests(userId);
            if(userProfileList!=null){

                return new ResponseEntity<>(userProfileList);
            }else{
                return new ResponseEntity<>(2001 , "No Users Found");
            }
        }





        @CrossOrigin
        @PostMapping(path ="/addfollower",produces = "application/json")
        public ResponseEntity addFollwer(@RequestParam(required = true) String userId,@RequestParam(required = true) String followerid) {
            boolean status= userService.addFolower(userId,followerid);
            if(status){
                return new ResponseEntity<>("Followed succesfully");
            }
            else {
                return new ResponseEntity<>(2005 , "U already follow ");
            }
        }
        @CrossOrigin
        @GetMapping("/byId")
        public ResponseEntity<UserEntity> getProductById(@RequestParam(required = true) String id){
            UserEntity userEntity= userService.getUserbyId(id);
            if(userEntity!=null){

                return new ResponseEntity<>(userEntity);
            }else{
                return new ResponseEntity<>(2002 , "User Not Found");
            }

        }
        @CrossOrigin
        @PostMapping(path ="/adduser",produces = "application/json")
        public ResponseEntity addUser(@RequestBody @Valid UserProfile userProfile){
           boolean status= userService.addUser(userProfile);
           if(status){
               return new ResponseEntity<>("User added succesfully");
           }
           else {
               return new ResponseEntity<>(2003 , "User Already exixts");
           }

        }

        @CrossOrigin
        @PostMapping(path ="/addfollowing",produces = "application/json")
        public ResponseEntity addFollwing(@RequestParam(required = true) String userId,@RequestParam(required = true) String followingid) {
            boolean status=userService.addFolowing(userId,followingid);
            if(status){
                return new ResponseEntity<>("Followed succesfully");
            }
            else {
                return new ResponseEntity<>(2003 , "User Already follow the user");
            }
        }

        @CrossOrigin
        @PostMapping(path ="/sendRequest",produces = "application/json")
        public void sendRequest(@RequestParam(required = true) String userId,@RequestParam(required = true) String requestId) {
            userService.sendRequest(userId,requestId);
        }

        @CrossOrigin
        @GetMapping("/feed")
        public ResponseEntity<List<QuestionDto>> feed(@RequestParam(required = true) String userId){
            List<QuestionDto> questionDtos= userService.feed(userId);

            if(questionDtos!=null){

                return new ResponseEntity<>(questionDtos);
            }
            else{
                return new ResponseEntity<>(2005 , "No new Posts");
            }

        }


        @CrossOrigin
        @DeleteMapping(produces = "application/json")
        public ResponseEntity delete(@RequestParam(required = true) String userId){
            boolean status= userService.deleteUser(userId);
            if(status){
                return new ResponseEntity<>("User deleted succesfully");
            }
            else {
                return new ResponseEntity<>(2003 , "Id doesnot exists");
            }

        }
    }


