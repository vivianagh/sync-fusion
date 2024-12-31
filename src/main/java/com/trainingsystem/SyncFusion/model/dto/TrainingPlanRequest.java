package com.trainingsystem.SyncFusion.model.dto;

import com.trainingsystem.SyncFusion.model.entity.ScheduledTraining;
import com.trainingsystem.SyncFusion.util.IntensityLevel;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TrainingPlanRequest {

    private Long athleteId;

    private LocalDate startDate;

    private LocalDate endDate;

    private IntensityLevel intensityLevel;

    private List<ScheduledTrainingDto> scheduledTrainingList;

    /**
     ENTRADA
     {
     "athleteId": 1,
     "startDate": "2024-10-30",
     "endDate": "2024-11-06",
     "intensityLevel": "GREEN",
     "scheduledTrainings": [
                                 {
                                 "dayOfWeek": "TUESDAY",
                                 "activities": [1, 6, 5]
                                 },
                                 {
                                 "dayOfWeek": "THURSDAY",
                                 "activities": [2, 7]
                                 },
                                 {
                                 "dayOfWeek": "SUNDAY",
                                 "activities": [4,5,6]
                                 }
                    ]
     }
     */
}
