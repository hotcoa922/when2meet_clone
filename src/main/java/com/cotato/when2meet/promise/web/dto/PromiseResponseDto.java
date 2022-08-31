package com.cotato.when2meet.promise.web.dto;

import com.cotato.when2meet.promise.model.Promise;
import com.cotato.when2meet.promise.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class PromiseResponseDto {
    private Long id;
    private String N_NE;    //약속이름
    private String WD_S;      //약속기간 중 시작날
    private String WD_E;      //약속기간 중 마지막날

    public PromiseResponseDto(Promise entity){
        this.id = entity.getId();
        this.N_NE = entity.getN_NE();
        this.WD_E = entity.getWD_E();
        this.WD_S = entity.getWD_S();
    }

}
