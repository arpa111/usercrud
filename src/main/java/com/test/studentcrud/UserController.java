package com.test.studentcrud;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private CustomUserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<CustomUser> createUser(@RequestBody CustomUser user) {
        CustomUser customUser = userService.createUser(user);
        return new ResponseEntity<CustomUser>(customUser,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomUser> getUserById(  @PathVariable Long id) {
        Optional<CustomUser> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public CustomUser updateUser(@PathVariable Long id, @RequestBody CustomUser userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}