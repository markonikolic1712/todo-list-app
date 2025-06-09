package com.company.todos.controller;

import com.company.todos.entity.Todo;
import com.company.todos.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    TodoServiceImpl service;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Todo>> getAllTodo() {
        List<Todo> todos = service.getAllTodo();
        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Long id) {
        Todo todo = service.getTodo(id);
        return ResponseEntity.status(HttpStatus.OK).body(todo);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo created = service.saveTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteTodoById(@PathVariable("id") Long id) {
        service.deleteTodo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo){
        Todo updated = service.updateTodo(id, todo);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
 }
