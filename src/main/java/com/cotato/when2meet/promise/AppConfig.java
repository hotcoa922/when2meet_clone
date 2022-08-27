package com.cotato.when2meet.promise;

import com.cotato.when2meet.promise.model.CheckRepository;
import com.cotato.when2meet.promise.model.PromiseRepository;
import com.cotato.when2meet.promise.model.UserRepository;
import com.cotato.when2meet.promise.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
JPA Audit
시간 데이터를 자동으로 데이터베이스 테이블에 넣어주는 기능.
 */
@EnableJpaAuditing
@Configuration
public class AppConfig {
}
