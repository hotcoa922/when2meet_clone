package com.cotato.when2meet.promise.service;

import com.cotato.when2meet.promise.model.Promisename;
import com.cotato.when2meet.promise.repository.WhoRepository;
import com.cotato.when2meet.promise.repository.NameRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TodoServiceImpl implements TodoService{
    private final WhoRepository whoRepository;
    private final NameRepository nameRepository;

    public TodoServiceImpl(WhoRepository whoRepository, NameRepository nameRepository) {
        this.whoRepository = whoRepository;
        this.nameRepository = nameRepository;
    }

    @Override
    public void join_todo(Promisename promisename) {
        nameRepository.save(promisename);
    }

    @Override
    public Promisename findTodo(Long todoId) {
        return nameRepository.findById(todoId);
    }

    @Override
    public void join_member(Long memberId, Long todoId) {
        Promisename promisename = findTodo(todoId);
        promisename.addMemberIdList(memberId);
    }

    @Override
    public void delete_member(Long memberId, Long todoId) {
        Promisename promisename = findTodo(todoId);
        promisename.deleteMemberIdList(memberId);
    }

    @Override
    public List<Long> findMembers(Long todoId) {
        Promisename promisename = findTodo(todoId);
        return promisename.getMemberIdList();
    }
}
