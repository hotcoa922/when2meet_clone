package com.cotato.when2meet.promise.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 이 어노테이션이 생성될 수 있는 위치를 지정
// 여기서는 메소드의 파라미터에서만 사용할 수 있다.
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
// @interface : 이 파일을 어노테이션 클래스로 지정한다.(@LoginUser 어노테이션 생성)
public @interface LoginUser {
}
