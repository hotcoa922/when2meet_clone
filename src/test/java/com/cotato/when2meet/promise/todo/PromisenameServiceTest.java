package com.cotato.when2meet.promise.todo;

import com.cotato.when2meet.promise.service.MemberService;
import com.cotato.when2meet.promise.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 이게 있어야 스프링 컨테이너에서 스프링 빈 객체 사용할 수 있음.
class PromisenameServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    TodoService todoService;

    /*
    @Test
    void 일정_생성(){
        // given
        Promisename promisename = new Promisename(2L,1L,"Todo1",220816L,220822L);

        // when
        todoService.join_todo(promisename);

        // then
        Assertions.assertThat(promisename.getTodoName()).isEqualTo("Todo1");
        Assertions.assertThat(promisename.getMemberIdList().get(0)).isEqualTo(2L);
    }

    @Test
    void 회원_추가(){
        // given
        Promisewho promisewhoA = new Promisewho(2L, "memberA");
        Promisename promisename = new Promisename(promisewhoA.getId(),1L,"Todo1",220816L,220822L);
        Promisewho promisewhoB = new Promisewho(3L,"memberB");
        // when
        todoService.join_todo(promisename);
        todoService.join_member(promisewhoB.getId(), promisename.getTodoId());
        // then
        Assertions.assertThat(todoService.findMembers(promisename.getTodoId()).get(1)).isEqualTo(promisewhoB.getId());
    }

    @Test
    void 회원_삭제(){
        // given
        Promisewho promisewhoA = new Promisewho(2L, "memberA");
        Promisename promisename = new Promisename(promisewhoA.getId(),1L,"Todo1",220816L,220822L);
        Promisewho promisewhoB = new Promisewho(3L,"memberB");
        // when
        todoService.join_todo(promisename);
        todoService.join_member(promisewhoB.getId(), promisename.getTodoId());
        todoService.delete_member(promisewhoA.getId(), promisename.getTodoId());
        // then
        Assertions.assertThat(todoService.findMembers(promisename.getTodoId()).get(0)).isEqualTo(promisewhoB.getId());
    }
    */

}