package com.company.todos.service;

import com.company.todos.entity.Todo;
import com.company.todos.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    TodoRepository repository;

    @Override
    public Todo getTodo(Long id) {
        Optional<Todo> entity = repository.findById(id);
        return unwrapTodo(entity);
    }

    @Override
    public Todo saveTodo(Todo todo) {
        todo.setCreatedAt(LocalDateTime.now());
        todo.setCompleted(false);
        return repository.save(todo);
    }

    @Override
    public Todo updateTodo(Long todoId, Todo newTodo) {
        Todo todo = getTodo(todoId);
        //todo.setTitle(newTodo.getTitle());
        todo.setDescription(newTodo.getDescription());
        todo.setCompleted(newTodo.isCompleted());
        todo.setCompletedAt(newTodo.getCompletedAt());
        todo.setDeletedAt(newTodo.getDeletedAt());
        todo.setModifiedAt(LocalDateTime.now());
        return repository.save(todo);
    }

    @Override
    public void deleteTodo(Long todoId) {
        repository.deleteById(todoId);
    }

    @Override
    public List<Todo> getAllTodo() {
        return (List<Todo>) repository.findAll();
    }

    static Todo unwrapTodo(Optional<Todo> entity) {
        if(entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException();
        }
    }
}
