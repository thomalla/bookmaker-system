package com.java.pk.controllers;

import com.java.pk.logic.BetsService;
import com.java.pk.logic.CoachesService;
import com.java.pk.logic.UserService;
import com.java.pk.persistence.model.Bets.Bets;
import com.java.pk.persistence.model.Coaches;
import com.java.pk.persistence.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Tomasz on 2017-11-15.
 */
@RestController
public class BetsController {

    private BetsService betsService;
    private UserService userService;
    private CoachesService coachesService;

    @Autowired
    public BetsController(BetsService betsService, UserService userService, CoachesService coachesService) {
        this.betsService = betsService;
        this.userService = userService;
        this.coachesService = coachesService;
    }

    /*    @RequestMapping(value = "/bets", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBets() {
            List<Bets> bets = betsService.findAll();
        return new ResponseEntity<Object>(bets, HttpStatus.OK);
    }*/
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {
        List<Users> users = userService.findAll();
        return new ResponseEntity<Object>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "/coaches", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCoaches() {
        List<Coaches> coaches = coachesService.findAll();
        return new ResponseEntity<Object>(coaches, HttpStatus.OK);
    }
}
