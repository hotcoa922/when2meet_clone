package com.cotato.when2meet.promise.web.dto;

import com.cotato.when2meet.promise.model.Promise;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PromiseCreationRequestDto {
    private String name;    //약속이름
    private String startDate;      //약속기간 중 시작날
    private String endDate;      //약속기간 중 마지막날

    @Builder
    public PromiseCreationRequestDto(String name, String startDate, String endDate){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Promise toEntity(){
        return Promise.builder()
                .name(this.name)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .build();
    }
}
