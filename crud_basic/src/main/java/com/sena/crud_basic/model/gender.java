package com.sena.crud_basic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="gender")
public class Gender {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gender_id")
    private int gender_id;

    @Column(name="name", length = 50, nullable = false)
    private String name;

    public Gender(int gender_id, String name) {
        this.gender_id = gender_id;
        this.name = name;
    }

    public void setGender_id(int gender_id) {
        this.gender_id = gender_id;
    }

    public int getGender_id() {
        return gender_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
