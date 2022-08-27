package com.cotato.when2meet.promise.web;

import com.cotato.when2meet.promise.service.UserService;
import com.cotato.when2meet.promise.web.dto.UserCreationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    // 생성
    @PostMapping("/api/v1/users")
    public Long save(@RequestBody UserCreationRequestDto requestDto){
        return userService.createUser(requestDto);
    }
}
