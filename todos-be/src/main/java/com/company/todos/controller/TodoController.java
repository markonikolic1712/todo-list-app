package com.company.todos.controller;

import com.company.todos.entity.Todo;
import com.company.todos.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    TodoServiceImpl service;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Todo>> getAllTodo() {
        // List<Todo> todos = service.getAllTodo();
        List<Todo> todos = service.getAllByDeletedAtIsNull();
        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo created = service.saveTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Long id) {
        Todo todo = service.getTodo(id);
        return ResponseEntity.status(HttpStatus.OK).body(todo);
    }

    @RequestMapping(value = "/complete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo){
        todo.setCompletedAt(LocalDateTime.now());
        System.out.println("complete: " + todo.getCompletedAt());
        Todo updated = service.updateTodo(id, todo);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    // kada korisnik klikne na delete dugme da izbrise neki todo taj red se ne brise iz baze nego se samo upisuje datetime u deletedAt
    // repository vraca samo one redove gde je: deletedAt IS NULL
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Todo> updateTodoDelete(@PathVariable("id") Long id, @RequestBody Todo todo){
        todo.setDeletedAt(LocalDateTime.now());
        System.out.println("delete: " + todo.getDeletedAt());
        Todo updated = service.updateTodo(id, todo);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<HttpStatus> deleteTodoById(@PathVariable("id") Long id) {
//        service.deleteTodo(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
 }
