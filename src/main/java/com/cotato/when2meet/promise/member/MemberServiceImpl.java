package com.cotato.when2meet.promise.member;

import com.cotato.when2meet.promise.repository.MemberRepository;

import javax.transaction.Transactional;

// 이 클래스의 매서드를 실행할 때 트랜잭션을 시작하고, 메서드가 정상 종료되면 트랜잭션을 커밋한다.
// JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행되어야 한다.
@Transactional
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByID(memberId);
    }
}
