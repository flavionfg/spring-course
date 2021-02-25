package com.springcourse.springcourse.dto;

import com.springcourse.springcourse.domain.Request;
import com.springcourse.springcourse.domain.RequestStage;
import com.springcourse.springcourse.domain.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class UserUpdatedto {

    @NotBlank(message = "Name required")
    private String name;

    @Email(message = "Invalid e-mail address")
    private String email;

    @Size(min = 7, max = 99, message = "Password must be between 7 and 99")
    private String password;

    private List<Request> requests = new ArrayList<Request>();
    private List<RequestStage> stages = new ArrayList<RequestStage>();

    public User trasnformToUser(){
        User user = new User(null, this.name,this.email,this.password,null,this.requests, this.stages );
        return user;
    }

    public @NotBlank(message = "Name required") String getName() {
        return this.name;
    }

    public @Email(message = "Invalid e-mail address") String getEmail() {
        return this.email;
    }

    public @Size(min = 7, max = 99, message = "Password must be between 7 and 99") String getPassword() {
        return this.password;
    }

    public List<Request> getRequests() {
        return this.requests;
    }

    public List<RequestStage> getStages() {
        return this.stages;
    }

    public void setName(@NotBlank(message = "Name required") String name) {
        this.name = name;
    }

    public void setEmail(@Email(message = "Invalid e-mail address") String email) {
        this.email = email;
    }

    public void setPassword(@Size(min = 7, max = 99, message = "Password must be between 7 and 99") String password) {
        this.password = password;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public void setStages(List<RequestStage> stages) {
        this.stages = stages;
    }
}
