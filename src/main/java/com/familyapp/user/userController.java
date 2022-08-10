package com.familyapp.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private IUserService userService;

    public UserController(IUserService us) {
            super();
            this.userService = us;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        List<User> users = this.userService.findAll();
        return users;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        User user = this.userService.findById(id);
        if(user == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("User not found");
        }
        return ResponseEntity.ok(user);

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean success = this.userService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("User not found");
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody User user){
        User newUser = this.userService.create(user);
        return ResponseEntity.ok(newUser);
    }
  
    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User formData) {
        User updatedUser = this.userService.update(id, formData);
        if(updatedUser == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("user not found");
        }
        return ResponseEntity.ok(updatedUser);
    }
}