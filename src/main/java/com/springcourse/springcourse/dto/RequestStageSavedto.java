package com.springcourse.springcourse.dto;


import com.springcourse.springcourse.domain.Request;
import com.springcourse.springcourse.domain.RequestStage;
import com.springcourse.springcourse.domain.User;
import com.springcourse.springcourse.domain.enums.RequestState;

import javax.validation.constraints.NotNull;


public class RequestStageSavedto {
    private String description;

    @NotNull(message = "State required")
    private RequestState state;

    @NotNull(message = "Request required")
    private Request request;

    @NotNull(message = "Owner required")
    private User owner;

    public RequestStageSavedto(String description, @NotNull(message = "State required") RequestState state, @NotNull(message = "Request required") Request request, @NotNull(message = "Owner required") User owner) {
        this.description = description;
        this.state = state;
        this.request = request;
        this.owner = owner;
    }

    public RequestStageSavedto() {
    }

    public RequestStage transformToRequestStage() {
        RequestStage stage = new RequestStage(null, description, null, state, this.request, owner);
        return stage;
    }

    public String getDescription() {
        return this.description;
    }

    public @NotNull(message = "State required") RequestState getState() {
        return this.state;
    }

    public @NotNull(message = "Request required") Request getRequest() {
        return this.request;
    }

    public @NotNull(message = "Owner required") User getOwner() {
        return this.owner;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(@NotNull(message = "State required") RequestState state) {
        this.state = state;
    }

    public void setRequest(@NotNull(message = "Request required") Request request) {
        this.request = request;
    }

    public void setOwner(@NotNull(message = "Owner required") User owner) {
        this.owner = owner;
    }
}