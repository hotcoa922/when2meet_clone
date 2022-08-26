package com.cotato.when2meet.promise.web.dto;

import com.cotato.when2meet.promise.model.Promise;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PromiseCreationRequestDto {
    private String N_NE;    //약속이름
    private int TZ;         //시간대
    private Long WD_S;      //약속기간 중 시작날
    private Long WD_E;      //약속기간 중 마지막날

    @Builder
    public PromiseCreationRequestDto(String N_NE, int TZ, Long WD_S, Long WD_E){
        this.N_NE = N_NE;
        this.TZ = TZ;
        this.WD_E = WD_E;
        this.WD_S = WD_S;
    }

    public Promise toEntity(){
        return Promise.builder()
                .N_NE(N_NE)
                .TZ(TZ)
                .WD_E(WD_E)
                .WD_S(WD_S)
                .build();
    }
}
