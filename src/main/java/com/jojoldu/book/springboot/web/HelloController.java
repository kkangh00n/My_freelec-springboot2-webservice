package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController     //JSON을 반환하는 컨트롤러
                    //@Responsebody를 클래스 전체의 적용
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        //RequestParam을 통해 넘긴 값을 변수 name의 할당 후 생성자 호출
        return new HelloResponseDto(name, amount);
    }
}
