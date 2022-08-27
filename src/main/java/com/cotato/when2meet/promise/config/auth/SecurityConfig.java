package com.cotato.when2meet.promise.config.auth;


//config.auth패키지에 시큐리티 관련 클래스 생성
import com.cotato.when2meet.promise.model.googleuser.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity      //스프링 시큐리티 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}

/*
 - .csrf().disable().headers().frameOptions().disable() -> h2-console화면 사용 위해 disabble
 - .authorizeRequests() -> URL별 권환 관리를 설정하느 ㄴ옵션의 시작점, 해당 부분이 선언되어야 antMatchers옵션 사용 가ㅡㄴㅇ
 - .antMatchers() -> 권한 관리 대상 지정, URL/HTTP메소드별로 관리 가능, permitall은 모든권한 준거고 hasRole의 경우 USER권한 가진 사람만 가능
 - .anyRequest -> 설정된 값들 이외 나머지 URL authenicated 추가하여 인증된 사용자만 허용하게 함
 - .logout().logoutSuccessUrl("/") -> 로그아웃 기능에 대한 설정의 진입점, 로그아웃 성공시 "/"주소로 리다이렉트함
 - .userInfoEndpoint() -> 로그인 성공 시 후속조치를 진행할 userService인터페이스의 구현체를 등록

 설정코드는 여기까지고 CustomOAuth2UserService클래스를 생성


 */
