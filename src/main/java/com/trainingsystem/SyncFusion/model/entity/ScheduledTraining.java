package com.trainingsystem.SyncFusion.model.entity;

import jakarta.persistence.*;
import com.trainingsystem.SyncFusion.util.IntensityLevel;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class ScheduledTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="training_plan_id")
    private TrainingPlan trainingPlan;

    private LocalDate date;

    private DayOfWeek dayOfWeek;

    private IntensityLevel intensityLevel;

    @ManyToMany
    @JoinTable(
            name = "scheduled_training_activities",
            joinColumns = @JoinColumn(name="scheduled_training_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_component_id")
    )
    private List<ActivityComponent> activities = new ArrayList<>();

    public ScheduledTraining() {

    }

    public ScheduledTraining(TrainingPlan trainingPlan, LocalDate date, DayOfWeek dayOfWeek, IntensityLevel intensityLevel, List<ActivityComponent> activities) {
        this.trainingPlan = trainingPlan;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.intensityLevel = intensityLevel;
        this.activities = activities;
    }
}
