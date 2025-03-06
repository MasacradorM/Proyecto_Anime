package com.sena.crud_basic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="country")
public class country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
    private int country_id;

    @Column(name="name", length = 50, nullable = false)
    private String name;
    
    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

