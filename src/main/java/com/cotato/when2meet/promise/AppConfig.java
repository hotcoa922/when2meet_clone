package com.cotato.when2meet.promise;

import com.cotato.when2meet.promise.repository.MemberRepository;
import com.cotato.when2meet.promise.member.MemberService;
import com.cotato.when2meet.promise.member.MemberServiceImpl;
import com.cotato.when2meet.promise.repository.MemoryTodoRepository;
import com.cotato.when2meet.promise.repository.TodoRepository;
import com.cotato.when2meet.promise.todo.TodoService;
import com.cotato.when2meet.promise.todo.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    private final MemberRepository memberRepository;
    private final TodoRepository todoRepository;

    @Autowired
    public AppConfig(MemberRepository memberRepository, TodoRepository todoRepository){
        this.memberRepository = memberRepository;
        this.todoRepository = todoRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository);
    }
    //@Bean
    //public static MemberRepository memberRepository() {
    //    return new MemoryMemberRepository();
    //}

    @Bean
    public TodoService todoService(){
        return new TodoServiceImpl(memberRepository, todoRepository);
    }

    //@Bean
    //public TodoRepository todoRepository() {
    //    return new MemoryTodoRepository();
    //}
}
