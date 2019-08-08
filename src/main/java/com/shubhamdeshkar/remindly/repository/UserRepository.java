package com.shubhamdeshkar.remindly.repository;

import com.shubhamdeshkar.remindly.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{

}
