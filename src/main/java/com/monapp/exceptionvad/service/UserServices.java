package com.monapp.exceptionvad.service;

import com.monapp.exceptionvad.Entity.User;
import com.monapp.exceptionvad.dto.UserRequest;
import com.monapp.exceptionvad.exception.UserException;
import com.monapp.exceptionvad.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    private UserRepo repo;

    public UserServices(UserRepo repo) {
        this.repo = repo;
    }

    public User saveUser(UserRequest userRequest){
        User user = new User();
        user.setUserId(0);
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setAge(userRequest.getAge());
        user.setMobile(userRequest.getMobile());
        user.setGender(userRequest.getGender());
        user.setNationality(userRequest.getNationality());
        return repo.save(user);
    }

    public List<User> getUsers(){
        return repo.findAll();
    }

    public User getUser(int id) throws UserException {
        User user = repo.findByUserId(id);
        if(user != null){
            return user;
        }else {
            throw new UserException("Utulisateur avec l'id "+id+" n'a pas ete retrouve");
        }
    }


}
