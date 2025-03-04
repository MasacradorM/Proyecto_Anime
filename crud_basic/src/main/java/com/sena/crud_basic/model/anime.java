package com.sena.crud_basic.model;
import jakarta.persistence.Entity;

import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="anime")
public class anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="anime_id")
    private int anime_id;

    @Column(name="titulo", length = 30, nullable = false)
    private String titulo;

    @Column(name="synopsis", nullable = false)
    private String synopsis;

    @Column(name="year_premiere", length = 30, nullable = false)
    private Year year_premiere;

    @Column(name="image", length = 150, nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "estudio_id", nullable = false)
    private estudio estudio;
   
}
