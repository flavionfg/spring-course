package com.springcourse.springcourse.service;

import com.springcourse.springcourse.domain.RequestFile;
import com.springcourse.springcourse.model.PageModel;
import com.springcourse.springcourse.model.PageRequestModel;
import com.springcourse.springcourse.repository.RequestFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RequestFileService {

    @Autowired
    private RequestFileRepository fileRepository;

    public PageModel<RequestFile> listAllByRequestId(Long requestId, PageRequestModel prm){
        Pageable pageable = PageRequest.of(prm.getPage(),prm.getSize());
        Page<RequestFile> page = fileRepository.findAllByRequestId(requestId, pageable);

        PageModel<RequestFile> pm = new PageModel<>((int)page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());

        return pm;
    }
}
