package com.java.pk.controllers;

import com.java.pk.logic.UserService;
import com.java.pk.persistence.model.Users;
import com.java.pk.persistence.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz on 2017-11-15.
 */
@RestController
//@RequestMapping("/users")
public class UsersController {



    /*@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUser() {

        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }*/

}
