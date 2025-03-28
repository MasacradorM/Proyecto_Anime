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

    @Column(name="name", length = 255, nullable = false)
    private String name;

    @Column(name="status",nullable =false, columnDefinition = "boolean default true ")
    private boolean status;

    public Gender(){}
    public Gender(int gender_id, String name, boolean status) {
        this.gender_id = gender_id;
        this.name = name;
        this.status = status;
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
    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
