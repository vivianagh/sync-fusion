package com.trainingsystem.SyncFusion.model.entity;

import jakarta.persistence.*;
import com.trainingsystem.SyncFusion.util.IntensityLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class ScheduledTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="training_plan_id")
    private TrainingPlan trainingPlan;

    private DayOfWeek dayOfWeek;

    @ManyToMany
    @JoinTable(
            name = "scheduled_training_activities",
            joinColumns = @JoinColumn(name="scheduled_training_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_component_id")
    )
    private List<ActivityComponent> activities = new ArrayList<>();

    public ScheduledTraining() {
    }

    public ScheduledTraining(TrainingPlan trainingPlan, DayOfWeek dayOfWeek, List<ActivityComponent> activities) {
        this.trainingPlan = trainingPlan;
        this.dayOfWeek = dayOfWeek;
        this.activities = activities;
    }
}
