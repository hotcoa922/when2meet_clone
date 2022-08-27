package com.cotato.when2meet.promise.service;

import com.cotato.when2meet.promise.model.PromiseCheck;
import com.cotato.when2meet.promise.model.CheckRepository;
import com.cotato.when2meet.promise.web.dto.CheckCreationRequestDto;
import com.cotato.when2meet.promise.web.dto.CheckResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
// Required : final 이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성
@RequiredArgsConstructor
@Transactional
public class CheckService {
    private final CheckRepository checkRepository;


    public PromiseCheck createCheck(CheckCreationRequestDto checkDto){
        return checkRepository.save(checkDto.toEntity());
    }

    public CheckResponseDto findCheck(Long id){
        PromiseCheck entity = checkRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 시간대가 선택된 바 없습니다. id = " + id));
        return new CheckResponseDto(entity);
    }

    // 삭제할 때는 굳이 Dto 로 감싸지 않아도 됨. 정보 유출등의 문제가 없으니까.
    public void deleteCheck(Long id){
        PromiseCheck check = checkRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 시간대가 선택된 바 없습니다. id = " + id));
        checkRepository.delete(check);
    }
}
