package com.cotato.when2meet.promise.web.dto;

import com.cotato.when2meet.promise.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreationRequestDto {
    private String U_ID;

    // 생성자가 많은 경우 @Builder을 통해 일관성있는 빌더 패턴을 제공
    @Builder
    public UserCreationRequestDto(String U_ID){
        this.U_ID = U_ID;
    }

    public User toEntity(){
        return User.builder()
                .U_ID(U_ID)
                .build();
    }

}
