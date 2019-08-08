package com.shubhamdeshkar.remindly.repository;

import com.shubhamdeshkar.remindly.entity.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, String>{
    public List<Todo> findByUser_id(String uId);
}
