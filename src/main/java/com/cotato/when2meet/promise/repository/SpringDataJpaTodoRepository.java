package com.cotato.when2meet.promise.repository;

import com.cotato.when2meet.promise.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaTodoRepository extends JpaRepository<Todo,Long>{

}
