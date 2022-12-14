package com.example.springbootsecurity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@Builder
@AllArgsConstructor
@Getter
public class UserJoinResponse {
    private String userName;
    private String emailAddress;
}