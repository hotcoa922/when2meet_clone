package com.cotato.when2meet.promise.member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
