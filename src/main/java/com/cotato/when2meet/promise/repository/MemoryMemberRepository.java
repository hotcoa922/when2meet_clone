package com.cotato.when2meet.promise.repository;

import com.cotato.when2meet.promise.member.Member;
import com.cotato.when2meet.promise.repository.MemberRepository;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findByID(Long memberId) {
        return store.get(memberId);
    }
}