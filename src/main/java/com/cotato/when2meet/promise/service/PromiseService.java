package com.cotato.when2meet.promise.service;

import com.cotato.when2meet.promise.model.Promise;
import com.cotato.when2meet.promise.model.PromiseRepository;
import com.cotato.when2meet.promise.web.dto.PromiseCreationRequestDto;
import com.cotato.when2meet.promise.web.dto.PromiseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
// Required : final 이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성
@RequiredArgsConstructor
public class PromiseService {

    private final PromiseRepository promiseRepository;

    @Transactional
    public Promise createPromise(PromiseCreationRequestDto promiseDto){
        return promiseRepository.save(promiseDto.toEntity());
    }

    public PromiseResponseDto findPromise(Long id){
        Promise entity = promiseRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 약속이 없습니다. id = " + id));
        return new PromiseResponseDto(entity);
    }

    // 삭제할 때는 굳이 Dto 로 감싸지 않아도 됨. 정보 유출등의 문제가 없으니까.
    @Transactional
    public void deletePromise(Long id){
        Promise promise = promiseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 약속이 없습니다. id = " + id));
        promiseRepository.delete(promise);
    }


}
