package com.cotato.when2meet.promise.todo;

import com.cotato.when2meet.promise.repository.MemberRepository;
import com.cotato.when2meet.promise.repository.TodoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TodoServiceImpl implements TodoService{
    private final MemberRepository memberRepository;
    private final TodoRepository todoRepository;

    public TodoServiceImpl(MemberRepository memberRepository, TodoRepository todoRepository) {
        this.memberRepository = memberRepository;
        this.todoRepository = todoRepository;
    }

    @Override
    public void join_todo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public Todo findTodo(Long todoId) {
        return todoRepository.findById(todoId);
    }

    @Override
    public void join_member(Long memberId, Long todoId) {
        Todo todo = findTodo(todoId);
        todo.addMemberIdList(memberId);
    }

    @Override
    public void delete_member(Long memberId, Long todoId) {
        Todo todo = findTodo(todoId);
        todo.deleteMemberIdList(memberId);
    }

    @Override
    public List<Long> findMembers(Long todoId) {
        Todo todo = findTodo(todoId);
        return todo.getMemberIdList();
    }
}
