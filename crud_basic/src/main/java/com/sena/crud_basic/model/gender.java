package com.sena.crud_basic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="gender")
public class gender {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gender_id")
    private int gender_id;

    @Column(name="name", length = 50, nullable = false)
    private String name;
}
