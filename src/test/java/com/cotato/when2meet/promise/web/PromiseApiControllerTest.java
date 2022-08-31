package com.cotato.when2meet.promise.web;

import com.cotato.when2meet.promise.model.Promise;
import com.cotato.when2meet.promise.model.PromiseRepository;
import com.cotato.when2meet.promise.model.UserRepository;
import com.cotato.when2meet.promise.web.dto.PromiseCreationRequestDto;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PromiseApiControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    PromiseRepository promiseRepository;
    UserRepository userRepository;

    // 단위 테스트마다 수행되는 메소드 지정(H2 초기화)
    @After
    public void cleanup() throws Exception{
        promiseRepository.deleteAll();
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
    public void 약속생성_불러오기() throws Exception{
        // given
        String name_A = "PromiseA";
        String WD_S_A = "220831";
        String WD_E_A = "220906";

        PromiseCreationRequestDto promiseCreationRequestDto = PromiseCreationRequestDto
                .builder()
                .N_NE(name_A)
                .WD_S(WD_S_A)
                .WD_E(WD_E_A)
                .build();

        String url = "http://localhost:" + port + "/api/v1/promise";

        // when

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(promiseCreationRequestDto)))
                .andExpect(status().isOk());

        //then

        List<Promise> all = promiseRepository.findAll();
        assertThat(all.get(0).getN_NE()).isEqualTo("PromiseA");
    }

    @WithMockUser(roles="USER")
    @Test
    public void 약속_조회하기(){
        //given
    }
}
