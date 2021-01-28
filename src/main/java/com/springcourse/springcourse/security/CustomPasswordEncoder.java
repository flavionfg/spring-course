package com.springcourse.springcourse.security;


import com.springcourse.springcourse.service.util.HashUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        String hash = HashUtil.getSecurityHash(rawPassword.toString());
        return hash;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassWord) {
        String hash = HashUtil.getSecurityHash(rawPassword.toString());
        return hash.equals(encodedPassWord);
    }
}