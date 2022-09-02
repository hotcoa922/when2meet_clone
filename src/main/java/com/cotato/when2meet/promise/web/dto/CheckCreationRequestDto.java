package com.cotato.when2meet.promise.web.dto;

import com.cotato.when2meet.promise.model.PromiseCheck;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class CheckCreationRequestDto {
    private Timestamp timeBlock; //시간선택(시작시간 기준 1시간단위)

    @Builder
    public CheckCreationRequestDto(Timestamp timeBlock){
        this.timeBlock = timeBlock;
    }

    public PromiseCheck toEntity(){
        return PromiseCheck.builder()
                .timeBlock(timeBlock)
                .build();
    }
}
