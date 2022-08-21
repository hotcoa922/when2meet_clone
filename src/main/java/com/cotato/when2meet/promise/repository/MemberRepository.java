package com.cotato.when2meet.promise.repository;

import com.cotato.when2meet.promise.member.Member;

public interface MemberRepository {
    void save(Member member);
    Member findByID(Long memberId);
}
