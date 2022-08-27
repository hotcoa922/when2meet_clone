package com.cotato.when2meet.promise.model.googleuser;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//각 사용자의 권한을 관리할 Enum 클래스 Role 클래스 생성
@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
/*

스프링 시큐리테에서 권한 코드에 항상 ROLE_ 가 앞에 있어야 한다.
코드별 키 값은 ROLE_GUEST ROLE_USER 등으로 지정

 */