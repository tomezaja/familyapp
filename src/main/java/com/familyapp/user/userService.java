package com.familyapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    private final userRepository userRepository;

    @Autowired
    public userService(com.familyapp.user.userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<user> getUser() {
        return userRepository.findAll();
    }

    public user findById(Integer id){
        try{
            return userRepository.findById(id).get();
        }catch (Exception e){
            return null;

        }
    }
}
