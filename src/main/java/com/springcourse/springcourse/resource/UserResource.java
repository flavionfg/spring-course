package com.springcourse.springcourse.resource;

import com.springcourse.springcourse.domain.Request;
import com.springcourse.springcourse.domain.User;
import com.springcourse.springcourse.dto.UserLogindto;
import com.springcourse.springcourse.dto.UserUpdateRoledto;
import com.springcourse.springcourse.model.PageModel;
import com.springcourse.springcourse.model.PageRequestModel;
import com.springcourse.springcourse.service.RequestService;
import com.springcourse.springcourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "users")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private RequestService requestService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User createdUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable(name = "id") long id, @RequestBody User user){
        user.setId(id);
        return ResponseEntity.ok(user);
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
    public ResponseEntity<User> Login(@RequestBody UserLogindto user){
        User loggedUser = userService.login(user.getEmail(),user.getPassword());
        return ResponseEntity.ok(loggedUser);
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

    @PatchMapping("/role/{id}")
    public ResponseEntity<?> updateRole(@PathVariable(name = "id") Long id,@RequestBody UserUpdateRoledto userdto){
    User user = new User();
    user.setId(id);
    user.setRole(userdto.getRole());

    userService.updateRole(user);
    return ResponseEntity.ok().build();
    }
}
