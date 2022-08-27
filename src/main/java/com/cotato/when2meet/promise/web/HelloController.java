package com.cotato.when2meet.promise.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
@RestController
컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
@ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용케 해주는 것이라고 생각하자.
 */

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
