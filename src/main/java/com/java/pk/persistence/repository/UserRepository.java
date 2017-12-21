package com.java.pk.persistence.repository;

import com.java.pk.persistence.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tomasz on 2017-11-15.
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

    List<Users>  findAll();
    Users save(Users user);
    Users findUsersByEmail(String username);
    Users findByUsername(String username);
   // boolean createUser(Users user);
}
