package com.cotato.when2meet.promise.member;

import javax.transaction.Transactional;


public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
