package com.trainingsystem.SyncFusion.model.entity;

import jakarta.persistence.*;
import com.trainingsystem.SyncFusion.util.ActivityName;
import com.trainingsystem.SyncFusion.util.ActivityType;
import lombok.Getter;

@Getter
@Entity
public class ActivityComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ActivityName name; //intervals long run farlek

    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    private String details;

    public ActivityComponent() {

    }
    public ActivityComponent(String name, ActivityType activityType, String details) {
        this.name = ActivityName.valueOf(name);
        this.activityType = activityType;
        this.details = details;
    }
}
