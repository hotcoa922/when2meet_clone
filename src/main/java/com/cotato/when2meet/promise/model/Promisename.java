package com.cotato.when2meet.promise.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;   //util? sql?
@Entity
@Data
public class Promisename {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;



    private int TZ; //시간대
    private Date WD_S;  //약속기간 중 시작날
    private Date WD_E;  //약속기간 중 마지막날
}