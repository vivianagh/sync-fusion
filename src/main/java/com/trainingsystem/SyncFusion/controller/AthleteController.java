package com.trainingsystem.SyncFusion.controller;

import com.trainingsystem.SyncFusion.model.dto.AthleteDto;
import com.trainingsystem.SyncFusion.service.AthleteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/athletes")
@Tag(name="Athlete API" , description = "Manage athletes")
public class AthleteController {

    private final AthleteService athleteService;

    @Autowired
    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @Operation(summary = "Get all athletes", description = "Retrieve a list of all athletes")
    @GetMapping
    public ResponseEntity<Page<AthleteDto>> getAllAthletes(@PageableDefault(page = 0, size = 5)Pageable pageable) {
        Page<AthleteDto> athleteList = athleteService.getAllAthletes(pageable);
        return new ResponseEntity<>(athleteList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary ="Create a new athlete", description = "Add a new athlete to the system")
    public ResponseEntity<AthleteDto> getAthleteById(@PathVariable Long id) {
        Optional<AthleteDto> athleteDto = athleteService.getAthleteById(id);
        return athleteDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AthleteDto> createAthlete(@RequestBody AthleteDto athlete) {
        System.out.println("Received athlete: " + athlete);
        AthleteDto createdAthlete = athleteService.createAthlete(athlete);
        return  ResponseEntity.ok(createdAthlete);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AthleteDto> updateAthlete(@PathVariable Long id, @RequestBody AthleteDto athleteDto) {
        System.out.println("Received athlete: " + athleteDto);
        athleteDto.setId(id);
        AthleteDto updateAthlete = athleteService.updateAthlete(athleteDto);
        return ResponseEntity.ok(updateAthlete);
    }
}
