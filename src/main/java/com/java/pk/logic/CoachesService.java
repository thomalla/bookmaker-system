package com.java.pk.logic;

import com.java.pk.persistence.model.Coaches;
import com.java.pk.persistence.repository.CoachesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomasz on 2017-12-13.
 */
@Service
public class CoachesService {

    private CoachesRepository coachesRepository;

    @Autowired
    public CoachesService(CoachesRepository coachesRepository){this.coachesRepository = coachesRepository;}

    public List<Coaches> findAll(){
        List<Coaches> coaches = coachesRepository.findAll();
        return coaches;
    }
}
