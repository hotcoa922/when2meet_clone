package com.cotato.when2meet.promise.repository;

import com.cotato.when2meet.promise.todo.Todo;

public interface TodoRepository {
    void save(Todo todo);
    Todo findById(Long todoId);
}
