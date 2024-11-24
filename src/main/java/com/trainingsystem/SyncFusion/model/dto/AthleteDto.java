package com.trainingsystem.SyncFusion.model.dto;

import com.trainingsystem.SyncFusion.util.PerformanceLevel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AthleteDto extends PersonDto implements Serializable {

    @NotNull(message = "Performance level is required")
    @Enumerated(EnumType.STRING)
    private PerformanceLevel performanceLevel;

    public AthleteDto(
            Long id,String name, String logoUrl, String lastname, String secondLastName,
            String email, String phone, String address, PerformanceLevel performanceLevel)
    {
        super(id,name, logoUrl, lastname, secondLastName, email, phone, address);
        this.performanceLevel = performanceLevel;
    }
}
