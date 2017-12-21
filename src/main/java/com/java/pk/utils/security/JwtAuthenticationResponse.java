package com.java.pk.utils.security;

import java.io.Serializable;

/**
 * Created by Tomasz on 2017-12-11.
 */
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        System.out.println("to ma byc token w response" + token);
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
