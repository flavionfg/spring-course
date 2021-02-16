package com.springcourse.springcourse.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "request_file")
public aspect RequestFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    private String name;

    @Column(columnDefinition = "text", nullable = false)
    private String location;

    @Getter(onMethod = @__(@JsonIgnore))
    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;
}
