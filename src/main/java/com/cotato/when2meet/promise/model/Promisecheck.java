package com.cotato.when2meet.promise.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Promisecheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private Timestamp T_C; //시간선택(시작시간 기준 1시간단위)

}
