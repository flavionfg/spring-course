package com.springcourse.springcourse.resource;

import com.springcourse.springcourse.domain.Request;
import com.springcourse.springcourse.domain.User;
import com.springcourse.springcourse.dto.*;
import com.springcourse.springcourse.model.PageModel;
import com.springcourse.springcourse.model.PageRequestModel;
import com.springcourse.springcourse.security.AccessManager;
import com.springcourse.springcourse.security.JwtManager;
import com.springcourse.springcourse.service.RequestService;
import com.springcourse.springcourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "users")
public class UserResource {

    @Autowired private UserService userService;
    @Autowired private RequestService requestService;
    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtManager jwtManager;
    @Autowired private AccessManager accessManager;


    @Secured({"ROLE_ADMINISTRATOR"})
    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid UserSavedto userdto){
        User userToSave = userdto.trasnformToUser();
        User createdUser = userService.save(userToSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PreAuthorize("@accessManager.isOwner(#id)")
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable(name = "id") long id, @RequestBody @Valid UserUpdatedto userdto){
        User user = userdto.trasnformToUser();
        user.setId(id);
        User updatedUser = userService.update(user);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable(name = "id") long id){
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<PageModel<User>> listAll(
           @RequestParam(value = "page", defaultValue = "0") int page,
           @RequestParam(value = "size", defaultValue = "10") int size){

        PageRequestModel pr = new PageRequestModel(page, size);
        PageModel<User> pm = userService.listAllOnLazyMode(pr);
           return ResponseEntity.ok(pm);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponsedto> Login(@RequestBody @Valid UserLogindto user){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
        Authentication auth = authManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(auth);

        org.springframework.security.core.userdetails.User userSpring =
                (org.springframework.security.core.userdetails.User) auth.getPrincipal();


        String email = userSpring.getUsername();
        List<String> roles =  userSpring.getAuthorities()
                .stream()
                .map(authority -> authority.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(jwtManager.createToken(email,roles));
    }

    @GetMapping("/{id}/request")
    public ResponseEntity<PageModel<Request>> listAllRequestById(
            @PathVariable(name = "id") Long id,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size){

        PageRequestModel pr = new PageRequestModel(page,size);
        PageModel<Request> pm = requestService.listAllByOwnerIdOnLazyMode(id,pr);

        return ResponseEntity.ok(pm);
    }

    @Secured({"ROLE_ADMINISTRATOR"})
    @PatchMapping("/role/{id}")
    public ResponseEntity<?> updateRole(@PathVariable(name = "id") Long id, @RequestBody @Valid UserUpdateRoledto userdto){
    User user = new User();
    user.setId(id);
    user.setRole(userdto.getRole());

    userService.updateRole(user);
    return ResponseEntity.ok().build();
    }

}
