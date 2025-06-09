package com.company.todos.repository;

import com.company.todos.entity.TodoUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoUserRepository extends CrudRepository<TodoUser, Long> {
}

