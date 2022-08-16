package com.cotato.when2meet.promise.todo;

public interface TodoRepository {
    void save(Todo todo);
    Todo findById(Long todoId);
}
