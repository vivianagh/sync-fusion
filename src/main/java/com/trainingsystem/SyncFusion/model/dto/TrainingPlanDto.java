package com.trainingsystem.SyncFusion.model.dto;

import com.trainingsystem.SyncFusion.util.IntensityLevel;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TrainingPlanDto {

    private Long id;

    private AthleteDto athlete;

    private LocalDate startDate;

    private LocalDate endDate;

    private IntensityLevel intensityLevel;

    private List<ScheduledTrainingCompleteDto> scheduledTrainingList;
}
