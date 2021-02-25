package com.springcourse.springcourse.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserLogindto {

    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Password required!")
    private String password;

    public UserLogindto(@Email(message = "Invalid email address") String email, @NotBlank(message = "Password required!") String password) {
        this.email = email;
        this.password = password;
    }

    public UserLogindto() {
    }

    public @Email(message = "Invalid email address") String getEmail() {
        return this.email;
    }

    public @NotBlank(message = "Password required!") String getPassword() {
        return this.password;
    }

    public void setEmail(@Email(message = "Invalid email address") String email) {
        this.email = email;
    }

    public void setPassword(@NotBlank(message = "Password required!") String password) {
        this.password = password;
    }
}
