package com.springcourse.springcourse.security;

import com.springcourse.springcourse.domain.Request;
import com.springcourse.springcourse.domain.User;
import com.springcourse.springcourse.exception.NotFoundException;
import com.springcourse.springcourse.repository.UserRepository;
import com.springcourse.springcourse.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("accessManager")
public class AccessManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RequestService requestService;

    public boolean isOwner(Long id) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> user = userRepository.findByEmail(email);

        if (!user.isPresent()) throw new NotFoundException("There are not user with email = " + email);

        User result = user.get();

        return result.getId().longValue() == id;
    }

    public boolean isRequestOwner(Long id){
        String email = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> result = userRepository.findByEmail(email);

        if(!result.isPresent()) throw new NotFoundException("There are not user with email = " + email);

        User user = result.get();

        Request request = requestService.getById(id);

        return user.getId().longValue() == request.getOwner().getId();
    }

}
