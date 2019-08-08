package com.shubhamdeshkar.remindly.controller;

import com.shubhamdeshkar.remindly.entity.Todo;
import com.shubhamdeshkar.remindly.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/users/{uId}")
public class TodoController {

    @Autowired
    private TodoRepository todoRepo;

    @PostMapping("/todos/new")
    public ResponseEntity createTodo(@PathVariable String uId, @RequestBody Todo todo) {
        Todo newTodo = todoRepo.save(todo);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newTodo.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

//    @GetMapping("/todos/{todoId}")
//    public void getTodo(@PathVariable String uId, @PathVariable String todoId) {
//
//    }
//
//    @PutMapping("/todos/{todoId}")
//    public void updateTodo(@PathVariable String uId, @PathVariable String todoId) {
//
//    }
//
//    @DeleteMapping("/todos/{todoId}")
//    public void deleteTodo(@PathVariable String uId, @PathVariable String todoId) {
//
//    }
//
//    @GetMapping("/todos")
//    public void getTodos(@PathVariable String uId) {
//
//    }
}
