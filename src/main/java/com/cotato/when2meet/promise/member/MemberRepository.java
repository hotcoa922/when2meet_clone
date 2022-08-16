package com.cotato.when2meet.promise.member;

public interface MemberRepository {
    void save(Member member);
    Member findByID(Long memberId);
}
