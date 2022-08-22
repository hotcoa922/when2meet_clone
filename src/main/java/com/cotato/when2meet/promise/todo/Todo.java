package com.cotato.when2meet.promise.todo;

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
public class Todo {
    private List<Long> memberIdList = new ArrayList<>(); // 여러명의 사용자를 가짐
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;
    private String todoName;
    private Long startDate;
    private Long endDate;

    public Todo(Long memberId,Long todoId, String todoName, Long startDate, Long endDate) {
        this.memberIdList.add(memberId);
        this.todoId = todoId;
        this.todoName = todoName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public List<Long> getMemberIdList() {
        return memberIdList;
    }

    public void addMemberIdList(Long memberId) {
        this.memberIdList.add(memberId);
    }
    public void deleteMemberIdList(Long memberId){
        this.memberIdList.remove(memberId);
    }

}
