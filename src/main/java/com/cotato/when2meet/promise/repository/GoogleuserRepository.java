package com.cotato.when2meet.promise.repository;

import com.cotato.when2meet.promise.model.googleuser.Googlelogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//CRUD를 위한 레포지토리 생성
public interface GoogleuserRepository extends JpaRepository<Googlelogin, Long> {

    Optional<Googlelogin> findByEmail(String email);    //findbyemail은 email을 통해 이미 생성된 사용자인지 처음 가입한 사용자인지 판단

}
