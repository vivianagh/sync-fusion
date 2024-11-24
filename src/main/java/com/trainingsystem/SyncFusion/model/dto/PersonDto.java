package com.trainingsystem.SyncFusion.model.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PersonDto {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "LastName is required")
    private String lastname;

    private String secondLastName;

    @Email(message = "Email should be valid")
    private String email;

    private String phone;

    private String address;

    private String logoUrl;

    public PersonDto(Long id, String name, String logoUrl, String lastname, String secondLastName, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.logoUrl = logoUrl;
        this.lastname = lastname;
        this.secondLastName = secondLastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
