package com.trainingsystem.SyncFusion.mapper;

import com.trainingsystem.SyncFusion.model.dto.TrainingPlanDto;
import com.trainingsystem.SyncFusion.model.dto.TrainingPlanResumeDto;
import com.trainingsystem.SyncFusion.model.entity.TrainingPlan;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TraininPlanMapper {

    private final ModelMapper modelMapper;

    public TraininPlanMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TrainingPlanResumeDto toResumeDto(TrainingPlan trainingPlan) {
        return modelMapper.map(trainingPlan, TrainingPlanResumeDto.class);
    }

    public TrainingPlanDto toDto(TrainingPlan trainingPlan) {
        return modelMapper.map(trainingPlan, TrainingPlanDto.class);
    }

    public TrainingPlan toEntity(TrainingPlanResumeDto trainingPlanDto) {
        return modelMapper.map(trainingPlanDto, TrainingPlan.class);
    }
}
