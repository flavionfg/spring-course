package com.springcourse.springcourse.dto;

import com.springcourse.springcourse.domain.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter @Setter
public class UserUpdateRoledto {

    @NotNull(message = "Role Required")
    private Role role;
}
