package com.cotato.when2meet.promise.web.dto;

import com.cotato.when2meet.promise.model.Promise;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PromiseCreationRequestDto {
    private String N_NE;    //약속이름
    private String WD_S;      //약속기간 중 시작날
    private String WD_E;      //약속기간 중 마지막날

    @Builder
    public PromiseCreationRequestDto(String N_NE, String WD_S, String WD_E){
        this.N_NE = N_NE;
        this.WD_S = WD_S;
        this.WD_E = WD_E;
    }

    public Promise toEntity(){
        return Promise.builder()
                .N_NE(N_NE)
                .WD_S(WD_S)
                .WD_E(WD_E)
                .build();
    }
}
