package com.springcourse.springcourse.resource;

import com.springcourse.springcourse.domain.Request;
import com.springcourse.springcourse.domain.RequestFile;
import com.springcourse.springcourse.domain.RequestStage;
import com.springcourse.springcourse.dto.RequestSavedto;
import com.springcourse.springcourse.dto.RequestUpdatedto;
import com.springcourse.springcourse.model.PageModel;
import com.springcourse.springcourse.model.PageRequestModel;
import com.springcourse.springcourse.security.AccessManager;
import com.springcourse.springcourse.service.RequestFileService;
import com.springcourse.springcourse.service.RequestService;
import com.springcourse.springcourse.service.RequestStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "requests")
public class RequestResource {

    @Autowired
    private RequestService requestService;

    @Autowired
    private RequestStageService requestStageService;

    @Autowired
    private AccessManager accessManager;

    @Autowired
    private RequestFileService fileService;

    @PostMapping
    public ResponseEntity<Request> save (@RequestBody @Valid RequestSavedto requestdto){
        Request request = requestdto.trasnformToRequest();
        Request savedRequest = requestService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRequest);
    }

    @PreAuthorize("@accessManager.isRequestOwner(#id)")
    @PutMapping("/{id}")
    public ResponseEntity<Request> update(@PathVariable(name = "id") Long id, @RequestBody @Valid RequestUpdatedto requestdto){
        Request request = requestdto.trasnformToRequest();
        request.setId(id);
        Request updatedRequest = requestService.update(request);
        return ResponseEntity.ok(updatedRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getById(@PathVariable(name = "id") Long id){
        Request request = requestService.getById(id);
        return  ResponseEntity.ok(request);
    }

    @GetMapping
    public ResponseEntity<PageModel<Request>> listAll(
            @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size){

        PageRequestModel pr = new PageRequestModel(page, size);
        PageModel<Request> pm = requestService.listAllOnLazyMode(pr);
        return ResponseEntity.ok(pm);
    }

    @GetMapping("/{id}/request-stages")
    public ResponseEntity<PageModel<RequestStage>> listAllStagesById(
            @PathVariable(name = "id") Long id,
            @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size){
            PageRequestModel pr = new PageRequestModel(page,size);
            PageModel<RequestStage> pm = requestStageService.listAllByRequestIdOnLazyMode(id, pr);
            return ResponseEntity.ok(pm);
    }

    @GetMapping("/{id}/files")
    public ResponseEntity<PageModel<RequestFile>> listAllFilesById(
            @PathVariable(name = "id") Long id,
            @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size){
        PageRequestModel pr = new PageRequestModel(page,size);
        PageModel<RequestFile> pm = fileService.listAllByRequestId(id,pr);
        return ResponseEntity.ok(pm);
    }

    @PostMapping("/{id}/files")
    public ResponseEntity<List<RequestFile>> upload(@RequestParam("files")MultipartFile[] files, @PathVariable(name = "id") Long id){
        List<RequestFile> requestFiles = fileService.upload(id,files);

        return ResponseEntity.status(HttpStatus.CREATED).body(requestFiles);
    }
}
