package com.shubhamdeshkar.remindly.controller;

import com.shubhamdeshkar.remindly.entity.Credentials;
import com.shubhamdeshkar.remindly.entity.User;
import com.shubhamdeshkar.remindly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/users")
public class AuthenticationController {

    // required dependencies
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public String home(){
        System.out.println("Hello, Homepage!");
        return "This is homepage";
    }

    @PostMapping("/signin") // The Get method is designed not to send payload. Hence, POST method here
    public ResponseEntity isRegistered(@RequestBody Credentials creds) {
        Optional<User> optionalUser = userRepo.findByEmail(creds.getEmail());
        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(creds.getPassword()))
            return ResponseEntity.ok(optionalUser.get());

        return ResponseEntity.notFound().build();
    }
}
