package com.example.QuoraUserProfile.services;

import com.example.QuoraUserProfile.dto.QuestionDto;
import com.example.QuoraUserProfile.dto.UserProfile;
import com.example.QuoraUserProfile.entities.FollowRequestEntity;
import com.example.QuoraUserProfile.entities.UserEntity;
import com.example.QuoraUserProfile.feign.Feed;
import com.example.QuoraUserProfile.repository.RequestRepository;
import com.example.QuoraUserProfile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    UserRepository userRepository;

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    Feed feed;



    @Override
    public UserEntity getUserbyId(String id) {


            Optional<UserEntity> userEntity= userRepository.findByuserId(id);
            if(userEntity.isPresent()){
                return userEntity.get();
            }
            else{
                return null;
            }
        }



    @Override
    public List<UserProfile> getAllusers() {


        Iterable<UserEntity> userEntities=userRepository.findAll();
        List<UserProfile> userProfileList=new ArrayList<>();
        for(UserEntity userEntity:userEntities){
            UserProfile user=new UserProfile(userEntity.getUserId(),userEntity.getUserName(),userEntity.getFollwingList(),userEntity.getFollowersList(),userEntity.getAccountType(),userEntity.getImage());
            userProfileList.add(user);
        }

        if(userProfileList.size()!=0)

        {return userProfileList;}
        else{
            return null;
        }

    }

    @Override
    public boolean addFolower(String userid,String follwerid) {
int c=0;
        if(follwerid.equals(userid)){
           return false;
        }
        Optional<UserEntity> userEntity=userRepository.findByuserId(userid);


        if(userEntity.isPresent()){


            List<String> follower = userEntity.get().getFollowersList();

            for(String var:follower){
                if(follwerid.equals(var)){
                    return false;
                }
                c++;
            }

            if(c==follower.size()){
                follower.add(follwerid);
                userRepository.save(userEntity.get());
                return true;
            }


            userEntity.get().setFollowersList(follower);
            userRepository.save(userEntity.get());
            return true;
        }

return false;
    }


    @Override
    public boolean addFolowing(String userid,String follwingid) {
int c=0;

        if(follwingid.equals(userid)){
            return false;
        }


        Optional<UserEntity> userEntity=userRepository.findByuserId(userid);
        if(userEntity.isPresent() ){
            List<String> following = userEntity.get().getFollwingList();

            for(String var:following){
                if(follwingid.equals(var)){
                    return false;
                }
                c++;
            }

            if(c==following.size()){
                following.add(follwingid);
                userRepository.save(userEntity.get());
                return true;
            }


            userEntity.get().setFollowersList(following);
            userRepository.save(userEntity.get());
            return true;
        }
            return false;
    }


    @Override
    public boolean addUser(UserProfile userProfile) {

        List<UserEntity> userEntityList =userRepository.findByuserName(userProfile.getUserName());
        if(userEntityList.size()==0) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(userProfile.getUserId());
            userEntity.setUserName(userProfile.getUserName());
            userEntity.setFollowersList(userProfile.getFollowersList());
            userEntity.setFollwingList(userProfile.getFollwingList());
            userEntity.setAccountType(userProfile.getAccountType());
            userEntity.setImage(userProfile.getImage());

            userRepository.save(userEntity);
            return true;
        }
else {
            return false;
        }
    }

    @Override
    public void sendRequest(String userId, String requestId) {
        Optional<UserEntity> userEntity=userRepository.findByuserId(requestId);
        if(userEntity.isPresent()){
            String type = userEntity.get().getAccountType();
            if(type.equals("Public")){
                addFolower(requestId,userId);
            }

            else
            {

                Optional<FollowRequestEntity> requestEntity=requestRepository.findByuserId(requestId);
//                System.out.println(requestId);
                if(requestEntity.isPresent()){
                    List<String> requests = requestEntity.get().getRequests();

                    requests.add(userId);

                    requestEntity.get().setRequests(requests);
                    requestRepository.save(requestEntity.get());
            }

            else{
                    FollowRequestEntity requestEntity1 =new FollowRequestEntity();
                    requestEntity1.setUserId(requestId);
                    List<String> requestsent=new ArrayList<>();
                    requestsent.add(userId);
                    requestEntity1.setRequests(requestsent);
                    requestRepository.save(requestEntity1);

                }

                }
        }


    }


    @Override
    public FollowRequestEntity getAllRequests(String userId) {


        Optional<FollowRequestEntity> followRequestEntity= requestRepository.findByuserId(userId);
        if(followRequestEntity.isPresent()){
            return followRequestEntity.get();
        }
        else{
            return null;
        }
    }







    @Override
    public List<QuestionDto> feed(String id) {



        Optional<UserEntity> userEntity=userRepository.findByuserId(id);
        if(userEntity.isPresent()){
            List<String> following = userEntity.get().getFollwingList();

            List<QuestionDto> questionEntities=feed.feedQuestion(following);

            Collections.reverse(questionEntities);
            return questionEntities;


        }
        else {
            return null;

        }



    }


//    @Override
//    public void updateUser(String id) {
////call using feign to fetch details and update
//
//    }

    @Override
    public boolean deleteUser(String id) {
       try {
           userRepository.deleteById(id);

           return true;
       }

       catch (Exception e){
           return false;
       }
    }
}
