package com.shubhamdeshkar.remindly.controller;

import com.shubhamdeshkar.remindly.entity.Todo;
import com.shubhamdeshkar.remindly.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

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

    @GetMapping("/todos/{todoId}")
    public ResponseEntity getTodo(@PathVariable String uId, @PathVariable String todoId) {
        Optional<Todo> optionalTodo = todoRepo.findById(todoId);
        if (optionalTodo.isPresent() && optionalTodo.get().getUser().getId().equals(uId))
            return ResponseEntity.ok(optionalTodo.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

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
