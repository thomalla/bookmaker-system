package com.java.pk.persistence.repository;

import com.java.pk.persistence.model.Bets.Bets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz on 2017-11-15.
 */
@Repository
public interface BetsRepository extends JpaRepository<Bets, Long> {
}
