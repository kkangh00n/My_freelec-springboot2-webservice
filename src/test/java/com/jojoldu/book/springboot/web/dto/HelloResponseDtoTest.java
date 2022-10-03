package com.jojoldu.book.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        //롬복을 이용한 생성자

        //then
        assertThat(dto.getName()).isEqualTo(name);
        //검증하고 싶은 대상을 assertThat의 인자로 받는다.
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
