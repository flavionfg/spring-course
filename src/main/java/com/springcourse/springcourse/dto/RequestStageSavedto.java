package com.springcourse.springcourse.dto;


import com.springcourse.springcourse.domain.Request;
import com.springcourse.springcourse.domain.RequestStage;
import com.springcourse.springcourse.domain.User;
import com.springcourse.springcourse.domain.enums.RequestState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class RequestStageSavedto {
    private String description;

    @NotNull(message = "State required")
    private RequestState state;

    @NotNull(message = "Request required")
    private Request request;

    @NotNull(message = "Owner required")
    private User owner;

    public RequestStage transformToRequestStage() {
        RequestStage stage = new RequestStage(null, description, null, state, this.request, owner);
        return stage;
    }
}