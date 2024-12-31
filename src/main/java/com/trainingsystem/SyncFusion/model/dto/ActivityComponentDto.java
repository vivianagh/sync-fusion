package com.trainingsystem.SyncFusion.model.dto;

import com.trainingsystem.SyncFusion.util.ActivityName;
import com.trainingsystem.SyncFusion.util.ActivityType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ActivityComponentDto {

    @Enumerated(EnumType.STRING)
    private ActivityName name; //intervals long run farlek

    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    private String details;

}
