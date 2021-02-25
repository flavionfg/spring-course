package com.springcourse.springcourse.dto;

import com.springcourse.springcourse.domain.Request;
import com.springcourse.springcourse.domain.RequestStage;
import com.springcourse.springcourse.domain.User;
import com.springcourse.springcourse.domain.enums.RequestState;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class RequestSavedto {

    @NotBlank(message = "Subject required")
    private String subject;
    private String description;

    @NotNull(message = "State required")
    private RequestState state;

    @NotNull(message = "Owner required")
    private User owner;
    private List<RequestStage> stages = new ArrayList<RequestStage>();

    public RequestSavedto(@NotBlank(message = "Subject required") String subject, String description, @NotNull(message = "State required") RequestState state, @NotNull(message = "Owner required") User owner, List<RequestStage> stages) {
        this.subject = subject;
        this.description = description;
        this.state = state;
        this.owner = owner;
        this.stages = stages;
    }

    public RequestSavedto() {
    }

    public Request trasnformToRequest(){
        Request request = new Request(null,this.subject,this.description,null,null,this.owner,stages,null);
        return request;
    }

    public @NotBlank(message = "Subject required") String getSubject() {
        return this.subject;
    }

    public String getDescription() {
        return this.description;
    }

    public @NotNull(message = "State required") RequestState getState() {
        return this.state;
    }

    public @NotNull(message = "Owner required") User getOwner() {
        return this.owner;
    }

    public List<RequestStage> getStages() {
        return this.stages;
    }

    public void setSubject(@NotBlank(message = "Subject required") String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(@NotNull(message = "State required") RequestState state) {
        this.state = state;
    }

    public void setOwner(@NotNull(message = "Owner required") User owner) {
        this.owner = owner;
    }

    public void setStages(List<RequestStage> stages) {
        this.stages = stages;
    }
}
