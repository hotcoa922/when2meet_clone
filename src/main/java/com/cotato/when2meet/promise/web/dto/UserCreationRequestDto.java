package com.cotato.when2meet.promise.web.dto;

import com.cotato.when2meet.promise.model.User;
import com.cotato.when2meet.promise.model.googleuser.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreationRequestDto {
    private String name;
    private String email;
    private String picture;
    private Role role;

    // 생성자가 많은 경우 @Builder을 통해 일관성있는 빌더 패턴을 제공
    @Builder
    public UserCreationRequestDto(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }
    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(role)
                .build();
    }

}
