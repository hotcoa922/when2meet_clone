package com.cotato.when2meet.promise.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Promise {
    //private List<Long> memberIdList = new ArrayList<>(); // 여러명의 사용자를 가짐
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String N_NE;    //약속이름
    private String WD_S;      //약속기간 중 시작날
    private String WD_E;      //약속기간 중 마지막날

    @Builder
    public Promise(String N_NE, String WD_S, String WD_E){
        this.N_NE = N_NE;
        this.WD_E = WD_E;
        this.WD_S = WD_S;
    }

/*
    public List<Long> getMemberIdList() {
        return memberIdList;
    }

    public void addMemberIdList(Long memberId) {
        this.memberIdList.add(memberId);
    }
    public void deleteMemberIdList(Long memberId){
        this.memberIdList.remove(memberId);
    }

 */

}
