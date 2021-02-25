package com.springcourse.springcourse.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springcourse.springcourse.domain.enums.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String name;

    @Column(length = 75, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 20, nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "owner")
    private List<Request> requests = new ArrayList<Request>();

    @OneToMany(mappedBy = "owner")
    private List<RequestStage> stages = new ArrayList<RequestStage>();

    public User(Long id, String name, String email, String password, Role role, List<Request> requests, List<RequestStage> stages) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.requests = requests;
        this.stages = stages;
    }

    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public Role getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public void setStages(List<RequestStage> stages) {
        this.stages = stages;
    }

    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    @JsonIgnore
    public List<Request> getRequests() {
        return this.requests;
    }

    @JsonIgnore
    public List<RequestStage> getStages() {
        return this.stages;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
