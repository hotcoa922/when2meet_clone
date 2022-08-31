package com.cotato.when2meet.promise.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Promise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String N_NE;    //약속이름
    @Column(nullable = false)
    private String WD_S;      //약속기간 중 시작날
    @Column(nullable = false)
    private String WD_E;      //약속기간 중 마지막날

    @Builder
    public Promise(String N_NE, String WD_S, String WD_E){
        this.N_NE = N_NE;
        this.WD_S = WD_S;
        this.WD_E = WD_E;
    }


    //public List<Long> getMemberIdList() {
    //    return memberIdList;
    //}

    //public void addMemberIdList(Long memberId) {
    //    this.memberIdList.add(memberId);
    //}
    //public void deleteMemberIdList(Long memberId){
    //this.memberIdList.remove(memberId);
    //}

}
