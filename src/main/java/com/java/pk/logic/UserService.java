package com.java.pk.logic;

import com.java.pk.persistence.model.Users;
import com.java.pk.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomasz on 2017-11-23.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    private PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<Users> findAll(){
        List<Users> user = userRepository.findAll();
        return user;
    }

    public Users createUser(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public Users getUserByEmail(String email){
        Users user = userRepository.findUsersByEmail(email);
        if (user == null) System.out.println("pusta wartosc");
        return user;
    }
}
