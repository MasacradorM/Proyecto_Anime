package com.sena.crud_basic.model;
import jakarta.persistence.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="season")
public class season {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="season_id")
    private int season_id;

    @Column(name="name", length = 50, nullable = false)
    private String name;

    @Column(name="release_date", nullable = false)
    private Date release_date;

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

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Date getRelease_date() {
        return release_date;
    }

}