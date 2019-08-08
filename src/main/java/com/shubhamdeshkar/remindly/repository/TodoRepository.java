package com.shubhamdeshkar.remindly.repository;

import com.shubhamdeshkar.remindly.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, String>{

}
