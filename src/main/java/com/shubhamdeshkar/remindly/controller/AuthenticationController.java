package com.shubhamdeshkar.remindly.controller;

import com.shubhamdeshkar.remindly.entity.Credentials;
import com.shubhamdeshkar.remindly.entity.User;
import com.shubhamdeshkar.remindly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"*"})
public class AuthenticationController {

    // required dependencies
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public String home(){
        return "This is homepage";
    }

    @GetMapping("/signin")
    public ResponseEntity isRegistered(@RequestBody Credentials creds) {
        Optional<User> optionalUser = userRepo.findByEmail(creds.getEmail());
        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(creds.getPassword()))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
