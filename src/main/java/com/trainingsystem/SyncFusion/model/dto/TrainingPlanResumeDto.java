package com.trainingsystem.SyncFusion.model.dto;


import com.trainingsystem.SyncFusion.util.IntensityLevel;
import lombok.Data;


import java.time.LocalDate;

@Data
public class TrainingPlanResumeDto {

    private Long id;

    private AthleteDto athlete;

    private LocalDate starDate;

    private LocalDate endDate;

    private IntensityLevel intensityLevel;


}
