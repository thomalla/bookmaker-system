package com.java.pk.controllers;


import com.java.pk.logic.UserService;
import com.java.pk.persistence.model.Users;
import com.java.pk.utils.security.JwtAuthenticationRequest;
import com.java.pk.utils.security.JwtAuthenticationResponse;
import com.java.pk.utils.security.JwtTokenUtil;
import com.java.pk.utils.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz on 2017-12-11.
 */
@RestController
@RequestMapping("/auth")
public class LoginController {


    @Value("${jwt.header}")
    private String tokenHeader;

    private UserService userService;
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/logIn", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {
//        try {
        System.out.println("USERNAME: "+authenticationRequest.getUsername()+"/nPASSWORD: "+authenticationRequest.getPassword());
        System.out.println("jestem w sign in");
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        System.out.println("jestem w sign in222222222222222222222222222222222222222222222");
        SecurityContextHolder.getContext().setAuthentication(authentication);
//        } catch(Exception e) {
//            e.printStackTrace();
//            System.out.println("ERR");
//        }


        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername( authenticationRequest.getUsername());
        System.out.println("dziala to kurestwo????????" + authenticationRequest.getPassword());
        final String token = jwtTokenUtil.generateToken(userDetails, device);
        System.out.println("token: "+token);
        // Return the token
//        try{
//            return new ResponseEntity<Object>(token, HttpStatus.OK);
//        } catch(Exception e) {
//            e.printStackTrace();
//            System.err.println("ERR");
//            return ResponseEntity.badRequest().body(null);
//        }

        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        token = token.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        System.out.println("jestem w refresh"+username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> createUser(@RequestBody Users user, UriComponentsBuilder builder) {
        System.out.println("jestem w create user");
        List<String> errors = new ArrayList<>();
        boolean flag = true;
        List<Users> users = userService.findAll();
        for(int i = 0; i < users.size(); i ++){
            if( users.get(i).getEmail().equals(user.getEmail())) {
                System.out.println("mail zajety");
                errors.add("Mail jest juz zajety");
                flag = false;
            }
            if( users.get(i).getUsername().equals(user.getUsername()) ){
                errors.add("Login jest juz zajety");
                flag = false;
            }
        }
        if(flag) {
            System.out.println("user sie tworzy");
            userService.createUser(user);
            // HttpHeaders headers = new HttpHeaders();
            //headers.setLocation(builder.path("/user?id={id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<Object>(errors, HttpStatus.CREATED);
        }
        return new ResponseEntity<Object>(errors, HttpStatus.OK);

    }
}
