package com.example.VirtualBookStore.Controllers;

import com.example.VirtualBookStore.Models.User;
import com.example.VirtualBookStore.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/signup")
    private ResponseEntity<User> registerUser(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        if(userService.registerUser(user))
            return new ResponseEntity<>(user, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    private ResponseEntity<User> updateUser(@RequestBody User user){
        User user1 = userService.findById(user.getId());
        if(user1 == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if(user.getName() != null || !user.getName().isBlank() || !user.getName().isEmpty())
            user1.setName(user.getName());
        if(user.getEmail() != null || !user.getEmail().isEmpty() || !user.getEmail().isBlank())
            user1.setEmail(user.getEmail());
        if(user.getPassword() != null || !user.getPassword().isBlank() || !user.getPassword().isEmpty())
            user1.setPassword(encoder.encode(user.getPassword()));
        if(user.getRole() != null || !user.getRole().isEmpty() || !user.getRole().isBlank())
            user1.setRole(user.getRole());
        if(user.getAddress() != null || !user.getAddress().isBlank() || !user.getAddress().isEmpty())
            user1.setAddress(user.getAddress());

        if(userService.registerUser(user1))
            return new ResponseEntity<>(user1, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
