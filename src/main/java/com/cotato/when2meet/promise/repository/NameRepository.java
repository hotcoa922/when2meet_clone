package com.cotato.when2meet.promise.repository;

import com.cotato.when2meet.promise.model.Promisename;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<Promisename, Long> {

}
