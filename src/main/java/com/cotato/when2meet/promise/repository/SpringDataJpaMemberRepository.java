package com.cotato.when2meet.promise.repository;

import com.cotato.when2meet.promise.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>{

}
