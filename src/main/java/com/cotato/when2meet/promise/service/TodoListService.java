package com.cotato.when2meet.promise.service;

import com.cotato.when2meet.promise.todo.Todo;

import java.util.List;

public interface TodoListService {
    void join_todo(Todo todo); // 일정 생성
    Todo findTodo(Long todoId); // 일정 조회
    void join_member(Long memberId, Long todoId); // 회원 추가
    void delete_member(Long memberId, Long todoId); // 회원 삭제
    List<Long> findMembers(Long todoId); // 멤버 조회
}
