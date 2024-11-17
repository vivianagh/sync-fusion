package com.trainingsystem.SyncFusion.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class TrainingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    private LocalDate starDate;

    private LocalDate endDate;

    @OneToMany(mappedBy = "trainingPlan")
    private List<ScheduledTraining> scheduledTrainings = new ArrayList<>();

    public TrainingPlan() {}


}
