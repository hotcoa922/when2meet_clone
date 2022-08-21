package com.cotato.when2meet.promise.repository;

import com.cotato.when2meet.promise.repository.TodoRepository;
import com.cotato.when2meet.promise.todo.Todo;

import java.util.HashMap;
import java.util.Map;

public class MemoryTodoRepository implements TodoRepository {

    private static Map<Long, Todo> store = new HashMap<>();

    @Override
    public void save(Todo todo) {
        store.put(todo.getTodoId(), todo);
    }

    @Override
    public Todo findById(Long todoId) {
        return store.get(todoId);
    }
}