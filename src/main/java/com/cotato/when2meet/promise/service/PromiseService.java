package com.cotato.when2meet.promise.service;

import com.cotato.when2meet.promise.model.Promise;
import com.cotato.when2meet.promise.model.PromiseRepository;
import com.cotato.when2meet.promise.web.dto.PromiseCreationRequestDto;
import com.cotato.when2meet.promise.web.dto.PromiseListResponseDto;
import com.cotato.when2meet.promise.web.dto.PromiseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
// Required : final 이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성
@RequiredArgsConstructor
public class PromiseService {

    private final PromiseRepository promiseRepository;

    @Transactional
    public Long createPromise(PromiseCreationRequestDto requestDto){
        return promiseRepository.save(requestDto.toEntity()).getId();
    }

    public PromiseResponseDto findPromise(Long id){
        Promise entity = promiseRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 약속이 없습니다. id = " + id));
        return new PromiseResponseDto(entity);
    }

    // readOnly : 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회속도가 개선됨.
    // 따라서, 등록, 수정, 삭제가 전혀 없는 서비스 메소드에 사용하는 것 추천함.
    @Transactional(readOnly = true)
    public List<PromiseListResponseDto> findAllDesc(){
        return promiseRepository.findAllDesc().stream()
                .map(PromiseListResponseDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    // 삭제할 때는 굳이 Dto 로 감싸지 않아도 됨. 정보 유출등의 문제가 없으니까.
    public void deletePromise(Long id){
        Promise promise = promiseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 약속이 없습니다. id = " + id));
        promiseRepository.delete(promise);
    }


}
