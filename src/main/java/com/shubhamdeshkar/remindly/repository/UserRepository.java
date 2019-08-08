package com.shubhamdeshkar.remindly.repository;

import com.shubhamdeshkar.remindly.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String>{
    public Optional<User> findByEmail(String email);
}
