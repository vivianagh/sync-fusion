package com.trainingsystem.SyncFusion.service;

import com.trainingsystem.SyncFusion.mapper.TraininPlanMapper;
import com.trainingsystem.SyncFusion.model.dto.ScheduledTrainingDto;
import com.trainingsystem.SyncFusion.model.dto.TrainingPlanDto;
import com.trainingsystem.SyncFusion.model.dto.TrainingPlanResumeDto;
import com.trainingsystem.SyncFusion.model.dto.TrainingPlanRequest;
import com.trainingsystem.SyncFusion.model.entity.ActivityComponent;
import com.trainingsystem.SyncFusion.model.entity.Athlete;
import com.trainingsystem.SyncFusion.model.entity.ScheduledTraining;
import com.trainingsystem.SyncFusion.model.entity.TrainingPlan;
import com.trainingsystem.SyncFusion.repository.ActivityComponentRepository;
import com.trainingsystem.SyncFusion.repository.AthleteRepository;
import com.trainingsystem.SyncFusion.repository.TrainingPlanRepository;
import com.trainingsystem.SyncFusion.util.IntensityLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingPlanService {

    private final AthleteRepository athleteRepository;

    private final ActivityComponentRepository activityComponentRepository;

    private final TraininPlanMapper trainingPlanMapper;

    private final TrainingPlanRepository trainingPlanRepository;

    public TrainingPlanService(
            AthleteRepository athleteRepository, ActivityComponentRepository activityComponentRepository,
            TraininPlanMapper traininPlanMapper, TrainingPlanRepository trainingPlanRepository
    ) {
        this.athleteRepository = athleteRepository;
        this.activityComponentRepository = activityComponentRepository;
        this.trainingPlanMapper = traininPlanMapper;
        this.trainingPlanRepository = trainingPlanRepository;
    }

    /**
     ENTRADA
     {
         "athleteId": 1,
         "startDate": "2024-10-30",
         "endDate": "2024-11-06",
         "intensityLevel": "GREEN",
         "scheduledTrainings": [
                             {
                                 "date": "2024-10-31",
                                 "dayOfWeek": "TUESDAY",
                                 "activities": [1, 6, 5]
                             },
                             {
                                 "date": "2024-11-02",
                                 "dayOfWeek": "THURSDAY",
                                 "activities": [2, 7]
                             },
                             {
                             "date": "2024-11-02",
                             "dayOfWeek": "SUNDAY",
                             "activities": [4,5,6]
                             }
        ]
     }
     */
    @Transactional
    public TrainingPlanResumeDto createTrainingPlan(TrainingPlanRequest trainingPlanRequest) {
        // Step 1: Fetch Athlete
        Athlete athlete = athleteRepository.findById(trainingPlanRequest.getAthleteId())
                                            .orElseThrow(() -> new RuntimeException("Athlete not found"));

        // Step 2: Create TrainingPlan
        TrainingPlan trainingPlan = new TrainingPlan(
                athlete, trainingPlanRequest.getStartDate(), trainingPlanRequest.getEndDate(),
                trainingPlanRequest.getIntensityLevel());

        // Step 3: Create ScheduledTraining
        List<ScheduledTraining> scheduledTrainingList = new ArrayList<>();
        for (ScheduledTrainingDto scheduledTrainings : trainingPlanRequest.getScheduledTrainingList()) {
            ScheduledTraining scheduledTraining = new ScheduledTraining();
            scheduledTraining.setTrainingPlan(trainingPlan);
            scheduledTraining.setDayOfWeek(scheduledTrainings.getDayOfWeek());
            List<ActivityComponent> activities = activityComponentRepository.findAllById(scheduledTrainings.getActivities());

            scheduledTraining.setActivities(activities);
            scheduledTrainingList.add(scheduledTraining);

        }

        // Save ScheduledTrainings (cascade saves activities)
        trainingPlan.setScheduledTrainings(scheduledTrainingList);
        TrainingPlan trainingPlanSaved = trainingPlanRepository.save(trainingPlan);
        return trainingPlanMapper.toResumeDto(trainingPlan);
    }

    public TrainingPlanDto getById (Long id) {
        TrainingPlan trainingPlan = trainingPlanRepository.findById(id).orElseThrow(() -> new RuntimeException("Training plan not found"));
        return trainingPlanMapper.toDto(trainingPlan);
    }

    public List<TrainingPlanDto> getByAthlete (Long athleteId) {
        List<TrainingPlan> trainingPlanList = trainingPlanRepository.findByAthleteId(athleteId);
        List<TrainingPlanDto> list = new ArrayList<TrainingPlanDto>();
        return trainingPlanList.stream().map(trainingPlanMapper::toDto).collect(Collectors.toList());
    }


    public Page<TrainingPlanDto> searchTrainingPlans(Long athleteId, IntensityLevel intensityLevel, LocalDate startDate, LocalDate endDate, Pageable pageable) {
        Page<TrainingPlan> trainingPlanList  = trainingPlanRepository.searchTrainingPlans(athleteId, intensityLevel, startDate, endDate,pageable);
        return trainingPlanList.map(trainingPlanMapper::toDto);
    }
}
