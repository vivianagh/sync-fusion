package com.trainingsystem.SyncFusion.model.dto;

import lombok.Data;

import java.time.DayOfWeek;
import java.util.List;

@Data
public class ScheduledTrainingCompleteDto {

    private DayOfWeek dayOfWeek;

    private List<ActivityComponentDto> activities;
}
