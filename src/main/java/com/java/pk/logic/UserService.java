package com.java.pk.logic;

import com.java.pk.persistence.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomasz on 2017-11-23.
 */
@Service
public class UserService {

    private UserService userRepository;
    @Autowired
    public UserService(UserService userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> findAll(){
        List<Users> user = userRepository.findAll();
        return user;
    }
}
