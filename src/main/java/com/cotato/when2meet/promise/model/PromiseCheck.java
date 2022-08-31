package com.cotato.when2meet.promise.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Entity
public class PromiseCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private Timestamp T_C; //시간선택(시작시간 기준 1시간단위)

    @Builder
    public PromiseCheck(Timestamp T_C){
        this.T_C = T_C;
    }
}
