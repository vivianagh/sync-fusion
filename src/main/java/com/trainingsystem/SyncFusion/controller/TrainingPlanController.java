package com.trainingsystem.SyncFusion.controller;

import com.trainingsystem.SyncFusion.mapper.TraininPlanMapper;
import com.trainingsystem.SyncFusion.model.dto.TrainingPlanDto;
import com.trainingsystem.SyncFusion.model.dto.TrainingPlanResumeDto;
import com.trainingsystem.SyncFusion.model.dto.TrainingPlanRequest;
import com.trainingsystem.SyncFusion.model.entity.TrainingPlan;
import com.trainingsystem.SyncFusion.service.TrainingPlanService;
import com.trainingsystem.SyncFusion.util.IntensityLevel;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/trainingPlans")
public class TrainingPlanController {

    private final TrainingPlanService trainingPlanService;

    public TrainingPlanController(TrainingPlanService trainingPlanService) {
        this.trainingPlanService = trainingPlanService;
    }

    @PostMapping
    public ResponseEntity<TrainingPlanResumeDto> create(@RequestBody TrainingPlanRequest trainingPlanRequest) {
        TrainingPlanResumeDto trainingPlan = trainingPlanService.createTrainingPlan(trainingPlanRequest);

        URI location  = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(trainingPlan.getId())
                    .toUri();

        return ResponseEntity.created(location).body(trainingPlan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingPlanDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(trainingPlanService.getById(id));
    }

    @GetMapping("/athletes/{athleteId}/training-plans")
    public ResponseEntity<List<TrainingPlanDto>> getByAthlete(@PathVariable Long athleteId) {
        return ResponseEntity.ok(trainingPlanService.getByAthlete(athleteId));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<TrainingPlanDto>> search(
            @RequestParam(required = false) Long athleteId,
            @RequestParam(required = false) IntensityLevel intensityLevel,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            Pageable pageable
    ) {
        Page<TrainingPlanDto> plans = trainingPlanService.searchTrainingPlans(athleteId, intensityLevel, startDate, endDate, pageable);
        return ResponseEntity.ok(plans);

    }

}
