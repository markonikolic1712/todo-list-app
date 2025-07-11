package com.company.todos.repository;

import com.company.todos.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    Optional<List<Todo>> findAllByDeletedAtIsNull();
}
