package com.cotato.when2meet.promise.web;

import com.cotato.when2meet.promise.service.CheckService;
import com.cotato.when2meet.promise.web.dto.CheckCreationRequestDto;
import com.cotato.when2meet.promise.web.dto.UserCreationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CheckApiController {
    private final CheckService checkService;

    @PostMapping("api/v1/check")
    public Long save(@RequestBody CheckCreationRequestDto requestDto){
        return checkService.createCheck(requestDto);
    }

    @DeleteMapping("api/v1/check/{id}")
    public Long delete(@PathVariable Long id){
        checkService.deleteCheck(id);
        return id;
    }
}
