package com.springcourse.springcourse.dto;

import java.io.Serializable;

public class UserLoginResponsedto implements Serializable {

    private String token;
    private Long expireIn;
    private String tokenProvider;

    public UserLoginResponsedto(String token, Long expireIn, String tokenProvider) {
        this.token = token;
        this.expireIn = expireIn;
        this.tokenProvider = tokenProvider;
    }

    public String getToken() {
        return this.token;
    }

    public Long getExpireIn() {
        return this.expireIn;
    }

    public String getTokenProvider() {
        return this.tokenProvider;
    }
}
