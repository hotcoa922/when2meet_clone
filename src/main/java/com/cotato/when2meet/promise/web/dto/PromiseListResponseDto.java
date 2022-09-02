package com.cotato.when2meet.promise.web.dto;

import com.cotato.when2meet.promise.model.Promise;
import lombok.Getter;

@Getter
public class PromiseListResponseDto {
    private Long id;
    private String name;
    private String startDate;
    private String endDate;

    public PromiseListResponseDto(Promise entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
    }
}
