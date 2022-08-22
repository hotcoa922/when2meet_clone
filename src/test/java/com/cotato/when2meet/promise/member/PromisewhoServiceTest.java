package com.cotato.when2meet.promise.member;

import com.cotato.when2meet.promise.model.Promisewho;
import com.cotato.when2meet.promise.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 이게 있어야 스프링 빈 객체 사용 가능
class PromisewhoServiceTest {
    @Autowired
    MemberService memberService;

    @Test
    void 회원_가입(){
        // given
        Promisewho promisewho = new Promisewho(1L, "memberA");
        // when
        memberService.join(promisewho);
        // then
        Assertions.assertThat(memberService.findMember(1L).getName()).isEqualTo("memberA");
    }
}