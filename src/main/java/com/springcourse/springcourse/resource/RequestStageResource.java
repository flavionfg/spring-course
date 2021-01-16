package com.springcourse.springcourse.resource;

import com.springcourse.springcourse.domain.RequestStage;
import com.springcourse.springcourse.dto.RequestStageSavedto;
import com.springcourse.springcourse.service.RequestStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "request-stages")
public class RequestStageResource {

    @Autowired
    RequestStageService requestStageService;

    @PostMapping
    public ResponseEntity <RequestStage> save(@RequestBody @Valid RequestStageSavedto requestStagedto){
        RequestStage requestStage = requestStagedto.transformToRequestStage();
        RequestStage savedRequestStage = requestStageService.save(requestStage);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRequestStage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestStage> getById(@PathVariable(name = "id") Long id){
        RequestStage requestStage = requestStageService.getById(id);
        return ResponseEntity.ok(requestStage);
    }
}
