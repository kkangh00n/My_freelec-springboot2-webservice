package com.jojoldu.book.springboot.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.access.SecurityConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@WebMvcTest (controllers = HelloController.class)       //Web에 집중할 수 있는 어노테이션 -> @Controller만 접근 가능
public class HelloControllerTest {
    @Autowired      //스프링 컨테이너가 관리하는 빈 주입받음
    private MockMvc mvc;            //HTTP get이나 Post등에 대한 API 테스트 할 수 있음
    
    @Test 
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        
        mvc.perform(get("/hello"))      //HTTP get 메소드 요청
                .andExpect(status().isOk())         //상태가 ok인지 검증
                .andExpect(content().string(hello));    //결과 값이 hello인지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())             //상태 괜찮나?
                .andExpect(jsonPath("$.name", is(name)))        //JSON응답 값을 필드 별로 검증
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
