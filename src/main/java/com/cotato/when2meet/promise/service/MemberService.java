package com.cotato.when2meet.promise.service;


import com.cotato.when2meet.promise.model.Promisewho;

public interface MemberService {
    void join(Promisewho promisewho);
    Promisewho findMember(Long memberId);
}
