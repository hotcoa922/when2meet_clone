package com.cotato.when2meet.promise.web.dto;

import com.cotato.when2meet.promise.model.User;
import lombok.Getter;

// 이미 있는 값을 조회하는 것이므로 생성자에 대한 어노테이션 필요 없다.
@Getter
public class UserResponseDto {
    private Long id;
    private String U_ID;

    public UserResponseDto(User entity){
        this.id = entity.getID();
        this.U_ID = entity.getU_ID();
    }
}
