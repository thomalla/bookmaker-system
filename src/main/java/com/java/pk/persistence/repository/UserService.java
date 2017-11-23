package com.java.pk.persistence.repository;

import com.java.pk.persistence.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tomasz on 2017-11-15.
 */
@Repository
public interface UserService extends JpaRepository<Users, Long>{

    public List<Users>  findAll();
  //  public void createUsers(Users user);
}
