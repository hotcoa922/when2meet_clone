package com.cotato.when2meet.promise.todo;

import com.cotato.when2meet.promise.AppConfig;
import com.cotato.when2meet.promise.member.Member;
import com.cotato.when2meet.promise.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest // 이게 있어야 스프링 컨테이너에서 스프링 빈 객체 사용할 수 있음.
class TodoServiceTest {

    @Autowired MemberService memberService;
    @Autowired TodoService todoService;

    @Test
    void 일정_생성(){
        // given
        Todo todo = new Todo(2L,1L,"Todo1",220816L,220822L);

        // when
        todoService.join_todo(todo);

        // then
        Assertions.assertThat(todo.getTodoName()).isEqualTo("Todo1");
        Assertions.assertThat(todo.getMemberIdList().get(0)).isEqualTo(2L);
    }

    @Test
    void 회원_추가(){
        // given
        Member memberA = new Member(2L, "memberA");
        Todo todo = new Todo(memberA.getId(),1L,"Todo1",220816L,220822L);
        Member memberB = new Member(3L,"memberB");
        // when
        todoService.join_todo(todo);
        todoService.join_member(memberB.getId(),todo.getTodoId());
        // then
        Assertions.assertThat(todoService.findMembers(todo.getTodoId()).get(1)).isEqualTo(memberB.getId());
    }

    @Test
    void 회원_삭제(){
        // given
        Member memberA = new Member(2L, "memberA");
        Todo todo = new Todo(memberA.getId(),1L,"Todo1",220816L,220822L);
        Member memberB = new Member(3L,"memberB");
        // when
        todoService.join_todo(todo);
        todoService.join_member(memberB.getId(),todo.getTodoId());
        todoService.delete_member(memberA.getId(),todo.getTodoId());
        // then
        Assertions.assertThat(todoService.findMembers(todo.getTodoId()).get(0)).isEqualTo(memberB.getId());
    }
}