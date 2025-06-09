package com.company.todos.service;

import com.company.todos.entity.TodoUser;

import java.util.List;

public interface TodoUserService {
    TodoUser getUser(Long id);
    List<TodoUser> getUsers();
    TodoUser saveUser(TodoUser user);
    void deleteUser(Long id);
    void updateUser(Long id, TodoUser user);
}
