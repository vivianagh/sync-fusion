package com.trainingsystem.SyncFusion.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    private String secondLastName;

    private String email;

    private String phone;

    private String address;

    private String logoUrl;

    public Person() {
        //Required by entity
    }

    public Person(String name, String lastname, String secondLastName, String email, String phone, String address, String logoUrl) {
        this.name = name;
        this.lastname = lastname;
        this.secondLastName = secondLastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.logoUrl = logoUrl;
    }
}
