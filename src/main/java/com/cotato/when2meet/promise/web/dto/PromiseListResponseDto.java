package com.cotato.when2meet.promise.web.dto;

import com.cotato.when2meet.promise.model.Promise;
import lombok.Getter;

@Getter
public class PromiseListResponseDto {
    private Long id;
    private String N_NE;
    private String WD_S;
    private String WD_E;

    public PromiseListResponseDto(Promise entity){
        this.id = entity.getId();
        this.N_NE = entity.getN_NE();
        this.WD_S = entity.getWD_S();
        this.WD_E = entity.getWD_E();
    }
}
