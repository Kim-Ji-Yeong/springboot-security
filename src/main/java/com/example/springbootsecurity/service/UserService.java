package com.example.springbootsecurity.service;

import com.example.springbootsecurity.domain.User;
import com.example.springbootsecurity.domain.dto.UserDto;
import com.example.springbootsecurity.domain.dto.UserJoinRequest;
import com.example.springbootsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto join(UserJoinRequest request){

//        userRepository.findByUserName(request.getUserName())
//                .orElseThrow(() -> new RuntimeException("해당 UserName이 중복 됩니다."));

        userRepository.findByUserName(request.getUserName())
                .ifPresent(user -> new RuntimeException("해당 UserName이 중복 됩니다."));

        User savedUser = userRepository.save(request.toEntity());

        return UserDto.builder()
                .id(savedUser.getId())
                .userName(savedUser.getUserName())
                .email(savedUser.getEmailAddress())
                .build();
    }
}
