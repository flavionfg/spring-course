package com.springcourse.springcourse.domain;


import com.springcourse.springcourse.domain.enums.RequestState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
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
}
