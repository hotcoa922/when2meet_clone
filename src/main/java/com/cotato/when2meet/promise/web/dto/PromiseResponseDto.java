package com.cotato.when2meet.promise.web.dto;

import com.cotato.when2meet.promise.model.Promise;
import lombok.Getter;

@Getter
public class PromiseResponseDto {
    private Long id;
    private String name;    //약속이름
    private String startDate;      //약속기간 중 시작날
    private String endDate;      //약속기간 중 마지막날

    public PromiseResponseDto(Promise entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
    }

}
