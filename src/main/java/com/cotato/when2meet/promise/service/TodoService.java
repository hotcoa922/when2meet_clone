package com.cotato.when2meet.promise.service;

import com.cotato.when2meet.promise.model.Promisename;

import java.util.List;

public interface TodoService {
    void join_todo(Promisename promisename); // 일정 생성
    Promisename findTodo(Long todoId); // 일정 조회
    void join_member(Long memberId, Long todoId); // 회원 추가
    void delete_member(Long memberId, Long todoId); // 회원 삭제
    List<Long> findMembers(Long todoId); // 멤버 조회
}
