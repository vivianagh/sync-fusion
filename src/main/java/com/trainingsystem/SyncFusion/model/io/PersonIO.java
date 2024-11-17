package com.trainingsystem.SyncFusion.model.io;

import lombok.Getter;
import lombok.Setter;

@Getter
public class PersonIO {

    private Long id;

    private String name;

    private String lastname;

    private String secondLastName;

    private String email;

    private String phone;

    private String address;

    private String logoUrl;

    public PersonIO() {
    }

    public PersonIO(Long id,String name, String logoUrl, String lastname, String secondLastName, String email, String phone, String address) {
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
