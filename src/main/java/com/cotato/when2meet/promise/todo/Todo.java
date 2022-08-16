package com.cotato.when2meet.promise.todo;

import java.util.ArrayList;
import java.util.List;

public class Todo {
    private List<Long> memberIdList = new ArrayList<>(); // 여러명의 사용자를 가짐
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

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }
}
