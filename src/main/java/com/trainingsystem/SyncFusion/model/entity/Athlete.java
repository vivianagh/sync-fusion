package com.trainingsystem.SyncFusion.model.entity;

import com.trainingsystem.SyncFusion.util.PerformanceLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Athlete extends Person{

    @Enumerated(EnumType.STRING)
    private PerformanceLevel performanceLevel;

    public Athlete() {
        super();
    }

    public Athlete(
            String name, String lastname, String secondLastName, String email, String phone, String address,
            String logoUrl, PerformanceLevel performanceLevel
    ) {
        super(name, lastname, secondLastName, email, phone, address, logoUrl);
        this.performanceLevel = performanceLevel;
    }


}
