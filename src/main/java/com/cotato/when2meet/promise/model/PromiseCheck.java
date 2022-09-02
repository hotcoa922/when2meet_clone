package com.cotato.when2meet.promise.model;


import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Entity
@Table(name = "promise_check")
public class PromiseCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp timeBlock; //시간선택(시작시간 기준 1시간단위)

    @Builder
    public PromiseCheck(Timestamp timeBlock){
        this.timeBlock = timeBlock;
    }
}
