package com.trainingsystem.SyncFusion.service;

import com.trainingsystem.SyncFusion.model.entity.Athlete;
import com.trainingsystem.SyncFusion.model.io.AthleteIO;
import com.trainingsystem.SyncFusion.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    @Autowired
    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public Athlete createAthlete(Athlete athlete) {
        //validar campos
        //mapear para devolver un AthleteIO
        return athleteRepository.save(athlete);
    }

    public Athlete getAthleteById(Long id) {
        return athleteRepository.findById(id).orElse(null);
    }

    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }
}
