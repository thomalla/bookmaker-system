package com.java.pk.logic;

import com.java.pk.persistence.model.Bets.Bets;
import com.java.pk.persistence.model.Bets.Handicap;
import com.java.pk.persistence.repository.BetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomasz on 2017-12-13.
 */
@Service
public class BetsService {

    private BetsRepository betsRepository;

    @Autowired
    public BetsService(BetsRepository betsRepository) {this.betsRepository = betsRepository;}

    public List<Handicap> findAll(){
        List<Handicap> bets = betsRepository.findAll();
        return bets;
    }
}
