package com.cotato.when2meet.promise.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "promise")
public class Promise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String name;    //약속이름

    private String startDate;      //약속기간 중 시작날

    private String endDate;      //약속기간 중 마지막날

    @Builder
    public Promise(String name, String startDate, String endDate){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
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
