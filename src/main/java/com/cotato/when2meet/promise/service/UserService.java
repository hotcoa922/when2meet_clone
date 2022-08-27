package com.cotato.when2meet.promise.service;

import com.cotato.when2meet.promise.model.User;
import com.cotato.when2meet.promise.model.UserRepository;
import com.cotato.when2meet.promise.web.dto.UserCreationRequestDto;
import com.cotato.when2meet.promise.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// @Service 를 통해 이미 스프링 컨테이너에 빈으로 등록했으므로, config에서 다시 올릴 필요 없다.
@Service
// Required : final 이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 어떤 연산에 트랜잭션을 보장하여, DB 에서 의도치 않은 값이 저장되거나 조회되는 것을 막는다.
    @Transactional
    public Long createUser (UserCreationRequestDto userDto){
        // Repository 에서 save 하면 나오는 ID를 return
        // Dto.toEntity 를 통해 UserDto 내용을 복사한 model Entity 객체를 넘긴다.
        return userRepository.save(userDto.toEntity()).getId();
    }

    // 조회는 Transaction 보장이 필요없다.
    public UserResponseDto findUser(Long id){
        User entity = userRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 유저가 없습니다. id = " + id));
        return new UserResponseDto(entity);
    }
}
