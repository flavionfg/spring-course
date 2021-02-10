package com.springcourse.springcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class UserLoginResponsedto implements Serializable {

    private String token;
    private Long expireIn;
    private String tokenProvider;
}
