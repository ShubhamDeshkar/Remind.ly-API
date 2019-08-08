package com.shubhamdeshkar.remindly.controller;

import com.shubhamdeshkar.remindly.entity.User;
import com.shubhamdeshkar.remindly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public String home() {
        return "This is homepage";
    }

    @PostMapping("/new")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        User newUser = userRepo.save(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{uId}")
    public ResponseEntity getUser(@PathVariable String uId) {
        Optional<User> optionalUser = userRepo.findById(uId);
        if (optionalUser.isPresent())
            return ResponseEntity.ok(optionalUser.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{uId}")
    public ResponseEntity<User> updateUser(@PathVariable String uId, @RequestBody User user) {
        User existingUser = userRepo.findById(uId).get();

        existingUser.setDateOfBirth(user.getDateOfBirth());
        existingUser.setPassword(user.getPassword());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());

        User updatedUser = userRepo.save(existingUser);
        return ResponseEntity.ok(updatedUser);
    }
}
