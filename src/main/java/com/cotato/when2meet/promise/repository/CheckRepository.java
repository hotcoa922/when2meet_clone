package com.cotato.when2meet.promise.repository;

import com.cotato.when2meet.promise.model.PromiseCheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRepository extends JpaRepository<PromiseCheck, Long> {

}
