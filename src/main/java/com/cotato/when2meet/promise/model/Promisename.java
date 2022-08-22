package com.cotato.when2meet.promise.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Promisename {
    //private List<Long> memberIdList = new ArrayList<>(); // 여러명의 사용자를 가짐
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String N_NE;    //약속이름
    private int TZ;         //시간대
    private Long WD_S;      //약속기간 중 시작날
    private Long WD_E;      //약속기간 중 마지막날

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
