package com.cotato.when2meet.promise;

import com.cotato.when2meet.promise.repository.WhoRepository;
import com.cotato.when2meet.promise.service.MemberService;
import com.cotato.when2meet.promise.service.MemberServiceImpl;
import com.cotato.when2meet.promise.repository.NameRepository;
import com.cotato.when2meet.promise.service.TodoService;
import com.cotato.when2meet.promise.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    private final WhoRepository whoRepository;
    private final NameRepository nameRepository;

    @Autowired
    public AppConfig(WhoRepository whoRepository, NameRepository nameRepository){
        this.whoRepository = whoRepository;
        this.nameRepository = nameRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(whoRepository);
    }
    //@Bean
    //public static MemberRepository memberRepository() {
    //    return new MemoryMemberRepository();
    //}

    @Bean
    public TodoService todoService(){
        return new TodoServiceImpl(whoRepository, nameRepository);
    }

    //@Bean
    //public TodoRepository todoRepository() {
    //    return new MemoryTodoRepository();
    //}
}
