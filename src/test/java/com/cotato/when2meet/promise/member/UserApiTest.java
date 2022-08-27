package com.cotato.when2meet.promise.member;

import com.cotato.when2meet.promise.model.User;
import com.cotato.when2meet.promise.model.UserRepository;
import com.cotato.when2meet.promise.model.googleuser.Role;
import com.cotato.when2meet.promise.web.dto.UserCreationRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 이게 있어야 스프링 빈 객체 사용 가능
public class UserApiTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    UserRepository userRepository;

    // 단위 테스트마다 수행되는 메소드 지정(H2 초기화)
    @After
    public void cleanup() throws Exception{
        userRepository.deleteAll();
    }

    // 시큐리티를 위해 MOCK 설정 부분이 들어가야함
    @Autowired
    private WebApplicationContext context;

    // @WithMockMvc가 mvc 하에서만 작동하기 때문에 해줘야 함
    private MockMvc mvc;

    @Before
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }


    // 시큐리티 때문에 ROLE 부여한 테스트가 되어야 함.
    @WithMockUser(roles="USER")
    @Test
    public void 유저생성_불러오기() throws Exception{
        // given
        String name = "UserA";
        String email = "wpals113@snu.ac.kr";
        String picture = "picture";

        UserCreationRequestDto requestDto = UserCreationRequestDto.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.USER)
                .build();

        String url = "http://localhost:" + port + "/api/v1/users";

        // when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then

        List<User> all = userRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
    }
}