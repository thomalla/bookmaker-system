package com.java.pk.persistence.repository;

import com.java.pk.persistence.model.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz on 2017-11-15.
 */
@Repository
public interface PlayersRepository extends JpaRepository<Players, Long> {
}
