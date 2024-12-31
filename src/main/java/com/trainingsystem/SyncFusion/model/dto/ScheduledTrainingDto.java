package com.trainingsystem.SyncFusion.model.dto;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Data
public class ScheduledTrainingDto {

    private DayOfWeek dayOfWeek;

    private List<Long> activities;
}
