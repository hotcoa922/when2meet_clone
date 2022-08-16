package com.cotato.when2meet.promise.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 이게 있어야 스프링 빈 객체 사용 가능
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Test
    void 회원_가입(){
        // given
        Member member = new Member(1L, "memberA");
        // when
        memberService.join(member);
        // then
        Assertions.assertThat(memberService.findMember(1L).getName()).isEqualTo("memberA");
    }
}