package com.java.pk.controllers;

import com.java.pk.persistence.model.Users;
import com.java.pk.persistence.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tomasz on 2017-11-15.
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUser() {
       List<Users> user = userService.findAll();
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void createUser() {
        System.out.println("jestem w create user");
    }
}
