package com.springcourse.springcourse.dto;

import com.springcourse.springcourse.domain.enums.Role;

import javax.validation.constraints.NotNull;


public class UserUpdateRoledto {

    @NotNull(message = "Role Required")
    private Role role;

    public @NotNull(message = "Role Required") Role getRole() {
        return this.role;
    }

    public void setRole(@NotNull(message = "Role Required") Role role) {
        this.role = role;
    }
}
