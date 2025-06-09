package com.company.todos.service;

import com.company.todos.entity.TodoUser;
import com.company.todos.repository.TodoUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class TodoUserServiceImpl implements TodoUserService {

    @Autowired
    TodoUserRepository repository;

    @Override
    public TodoUser getUser(Long id) {
        Optional<TodoUser> entity = repository.findById(id);
        return unwrapUser(entity, id);
    }

    @Override
    public List<TodoUser> getUsers() {
        return (List<TodoUser>) repository.findAll();
    }

    @Override
    public TodoUser saveUser(TodoUser user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, TodoUser user) {
        TodoUser todoUser = getUser(id);
//        todoUser.setFirstName(user.getFirstName());
//        todoUser.setLastName(user.getLastName());
        repository.save(todoUser);
    }

    static TodoUser unwrapUser(Optional<TodoUser> entity, Long id) {
        if(entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException();
        }
    }
}
