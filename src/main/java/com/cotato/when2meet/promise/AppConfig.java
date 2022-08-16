package com.cotato.when2meet.promise;

import com.cotato.when2meet.promise.member.MemberRepository;
import com.cotato.when2meet.promise.member.MemberService;
import com.cotato.when2meet.promise.member.MemberServiceImpl;
import com.cotato.when2meet.promise.member.MemoryMemberRepository;
import com.cotato.when2meet.promise.todo.MemoryTodoRepository;
import com.cotato.when2meet.promise.todo.TodoRepository;
import com.cotato.when2meet.promise.todo.TodoService;
import com.cotato.when2meet.promise.todo.TodoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public TodoService todoService(){
        return new TodoServiceImpl(memberRepository(), todoRepository());
    }

    @Bean
    public TodoRepository todoRepository() {
        return new MemoryTodoRepository();
    }
}
