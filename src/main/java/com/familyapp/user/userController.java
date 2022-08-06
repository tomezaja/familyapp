package com.familyapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(path = "api/user")
public class userController {
    private final userService userService;

    @Autowired
    public userController(com.familyapp.user.userService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<user> getUser() {
        return userService.getUser();
    }

    @GetMapping("/{id}")
    public user findById(@PathVariable Integer id){
        return userService.findById(id);
    }


}
