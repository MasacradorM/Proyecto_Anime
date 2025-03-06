package com.sena.crud_basic.model;
import jakarta.persistence.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="season")
public class Season {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="season_id")
    private int season_id;

    @Column(name="name", length = 50, nullable = false)
    private String name;

    @Column(name="release_date", nullable = false)
    private LocalDate release_date;

    public void setSeason_id(int season_id) {
        this.season_id = season_id;
    }

    public int getSeason_id() {
        return season_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

}