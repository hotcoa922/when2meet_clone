package com.cotato.when2meet.promise.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
// BaseTimeEntity 를 상속받아 엔티티 객체 생성 및 변경시 마다 시간 기록
public class User extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String U_ID;

    // 생성자가 많은 경우 @Builder 을 통해 일관성있는 빌더 패턴을 제공
    @Builder // Lombok, 해당 클래스의 빌더 패턴 클래스를 생성, 생성자에 포함된 필드만 빌더에 포함
    public User(String U_ID){
        this.U_ID = U_ID;
    }


}

