package com.cotato.when2meet.promise.repository;

import com.cotato.when2meet.promise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
