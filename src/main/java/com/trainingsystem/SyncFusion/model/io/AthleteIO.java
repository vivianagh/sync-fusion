package com.trainingsystem.SyncFusion.model.io;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class AthleteIO extends PersonIO implements Serializable {

    private String performanceLevel;

    public AthleteIO(
            Long id,String name, String logoUrl, String lastname, String secondLastName,
            String email, String phone, String address, String performanceLevel)
    {
        super(id,name, logoUrl, lastname, secondLastName, email, phone, address);
        this.performanceLevel = performanceLevel;
    }
}
