package com.springcourse.springcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserLogindto {

    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Password required!")
    private String password;
}
