package com.sena.crud_basic.model;
import jakarta.persistence.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="seanson")
public class seanson {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seanson_id")
    private int seanson_id;

    @Column(name="name", length = 50, nullable = false)
    private String name;

    @Column(name="release_date", nullable = false)
    private Date release_date;

}
