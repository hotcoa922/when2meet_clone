package com.cotato.when2meet.promise.repository;

import com.cotato.when2meet.promise.model.Promisecheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRepository extends JpaRepository<Promisecheck, Long> {

}
