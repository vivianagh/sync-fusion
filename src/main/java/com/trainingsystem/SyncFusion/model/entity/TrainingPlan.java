package com.trainingsystem.SyncFusion.model.entity;

import com.trainingsystem.SyncFusion.util.IntensityLevel;
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

    private LocalDate startDate;

    private LocalDate endDate;

    private IntensityLevel intensityLevel;

    @OneToMany(mappedBy = "trainingPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ScheduledTraining> scheduledTrainings = new ArrayList<>();

    public TrainingPlan() {}

    public TrainingPlan(Athlete athlete, LocalDate startDate, LocalDate endDate, IntensityLevel intensityLevel) {
        this.athlete = athlete;
        this.startDate = startDate;
        this.endDate = endDate;
        this.intensityLevel = intensityLevel;
    }

    public void setScheduledTrainings(List<ScheduledTraining> scheduledTrainings) {
        this.scheduledTrainings = scheduledTrainings;
    }
}
