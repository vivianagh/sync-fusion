package com.trainingsystem.SyncFusion.model.entity;

import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Athlete extends Person{

    private String performanceLevel;

    public Athlete() {
        super();
    }

    public Athlete(
            String name, String lastname, String secondLastName, String email, String phone, String address,
            String logoUrl, String performanceLevel
    ) {
        super(name, lastname, secondLastName, email, phone, address, logoUrl);
        this.performanceLevel = performanceLevel;
    }


}
