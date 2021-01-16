package com.springcourse.springcourse.dto;

import com.springcourse.springcourse.domain.Request;
import com.springcourse.springcourse.domain.RequestStage;
import com.springcourse.springcourse.domain.User;
import com.springcourse.springcourse.domain.enums.RequestState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RequestUpdatedto {

    @NotBlank(message = "Subjecte required")
    private String subject;
    private String description;

    @NotNull(message = "State required")
    private RequestState state;

    @NotNull(message = "Owner Required")
    private User owner;
    private List<RequestStage> stages = new ArrayList<RequestStage>();

    public Request trasnformToRequest(){
        Request request = new Request(null, this.subject, this.description, null,this.state, this.owner, stages);
        return request;
    }
}
