package com.company.todos.service;

import com.company.todos.entity.Todo;

import java.util.List;

public interface TodoService {
    Todo getTodo(Long id);
    Todo saveTodo(Todo todo);
    Todo updateTodo(Long todoId, Todo todo);
    void deleteTodo(Long todoId);
    List<Todo> getAllTodo();
    List<Todo> getAllByDeletedAtIsNull();
}
