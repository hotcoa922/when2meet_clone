package com.cotato.when2meet.promise.model;

import com.cotato.when2meet.promise.model.Promise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PromiseRepository extends JpaRepository<Promise, Long> {
    @Query("SELECT p FROM Promise p ORDER BY p.id DESC")
    List<Promise> findAllDesc();
}
