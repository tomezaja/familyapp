package com.familyapp.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private UserRepository users;

    public UserService(UserRepository ur) {
        super();
        this.users = ur;
    }

    @Override
    public User findById(long id){
        try {
            return this.users.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> findAll(){
        return this.users.findAll();
    }

    @Override
    public boolean delete(long id){
        User u = this.findById(id);
        try {
            this.users.delete(u);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public User create(User u){
        u = this.users.save(u);
        return u;
    }

    

    @Override
    public User update(long id, User formData){
        User oldUser = this.findById(id);
        if(oldUser == null){
            return null;
        }
        if (formData.getName() != null) {
            oldUser.setName(formData.getName());  
        }else{
            oldUser.setName(oldUser.getName());
        }
        if (formData.getPicture() != null) {
            oldUser.setPicture(formData.getPicture());  
        }else{
            oldUser.setPicture(oldUser.getPicture());
        }
        if (formData.getBirthday() != null) {
            oldUser.setBirthday(formData.getBirthday());  
        }else{
            oldUser.setBirthday(oldUser.getBirthday());
        }
        
       

        return this.users.save(oldUser);
    }


}
    

