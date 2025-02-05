package com.example.VirtualBookStore.Services;

import com.example.VirtualBookStore.Models.User;
import com.example.VirtualBookStore.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    AuthenticationManager authManager;


    public boolean registerUser(User user) {
        try {
            userRepository.save(user);
            return true;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public String verify(User user) {
        //Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

//        if(authentication.isAuthenticated()){
//            return "done";
//        }
        return "Failure";
    }
}
