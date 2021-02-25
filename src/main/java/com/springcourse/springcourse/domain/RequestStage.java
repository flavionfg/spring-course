package com.springcourse.springcourse.domain;


import com.springcourse.springcourse.domain.enums.RequestState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "request_stage")
public class RequestStage implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "realization_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date realizationDate;

    @Column(length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestState state;

    @ManyToOne
    @JoinColumn(name = "request_id",nullable = false)
    private Request request;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    public RequestStage(Long Id, String description, Date realizationDate, RequestState state, Request request, User owner) {
        this.Id = Id;
        this.description = description;
        this.realizationDate = realizationDate;
        this.state = state;
        this.request = request;
        this.owner = owner;
    }

    public RequestStage() {
    }

    public Long getId() {
        return this.Id;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getRealizationDate() {
        return this.realizationDate;
    }

    public RequestState getState() {
        return this.state;
    }

    public Request getRequest() {
        return this.request;
    }

    public User getOwner() {
        return this.owner;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRealizationDate(Date realizationDate) {
        this.realizationDate = realizationDate;
    }

    public void setState(RequestState state) {
        this.state = state;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
