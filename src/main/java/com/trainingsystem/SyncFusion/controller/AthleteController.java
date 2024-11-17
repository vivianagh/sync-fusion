package com.trainingsystem.SyncFusion.controller;

import com.trainingsystem.SyncFusion.model.entity.Athlete;
import com.trainingsystem.SyncFusion.model.io.AthleteIO;
import com.trainingsystem.SyncFusion.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/athletes")
public class AthleteController {

    private final AthleteService athleteService;

    @Autowired
    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping
    public ResponseEntity<List<Athlete>> getAllAthletes() {
        List<Athlete> athleteList = athleteService.getAllAthletes();

        return new ResponseEntity<>(athleteList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Athlete> getAthleteById(@PathVariable Long id) {
        Athlete athlete = athleteService.getAthleteById(id);
        if (athlete != null) {
            return new ResponseEntity<>(athlete, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Athlete> createAthlete(@RequestBody Athlete athlete) {
        System.out.println("Received athlete: " + athlete);
        Athlete createdAthlete = athleteService.createAthlete(athlete);
        return new ResponseEntity<>(createdAthlete, HttpStatus.CREATED);
    }
}
