package com.cotato.when2meet.promise.web;

import com.cotato.when2meet.promise.service.PromiseService;
import com.cotato.when2meet.promise.web.dto.PromiseCreationRequestDto;
import com.cotato.when2meet.promise.web.dto.PromiseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PromiseApiController {
    private final PromiseService promiseService;

    // 생성 작업
    @PostMapping("/api/v1/promise")
    public Long save(@RequestBody PromiseCreationRequestDto requestDto){
        return promiseService.createPromise(requestDto);
    }
    // 조회 작업
    @GetMapping("/api/v1/promise/{id}")
    public PromiseResponseDto findById(@PathVariable Long id) {
        return promiseService.findPromise(id);
    }
}
