package com.cotato.when2meet.promise.web.dto;

import com.cotato.when2meet.promise.model.PromiseCheck;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class CheckResponseDto {
    private Long id;
    private Timestamp timeBlock; //시간선택(시작시간 기준 1시간단위)

    public CheckResponseDto(PromiseCheck entity){
        this.id = entity.getId();
        this.timeBlock = entity.getTimeBlock();
    }

}
