package com.cotato.when2meet.promise.member;

import com.cotato.when2meet.promise.model.User;
import com.cotato.when2meet.promise.repository.UserRepository;
import com.cotato.when2meet.promise.service.UserService;
import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest // 이게 있어야 스프링 빈 객체 사용 가능
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void 회원_가입(){
        // given
        String name1 = "UserA";
        String name2 = "UserB";

        // .save() -> 테이블에 insert/update 쿼리를 수행.
        // id가 있으면 update, 없으면 insert 수행
        userRepository.save(User.builder()
                .U_ID(name1)
                .build());
        userRepository.save(User.builder()
                .U_ID(name2)
                .build());


        // when
        List<User> all = userRepository.findAll();

        // then
        Assertions.assertThat(all.get(0)).isEqualTo("userA");
        Assertions.assertThat(all.get(1)).isEqualTo("userB");
    }
}