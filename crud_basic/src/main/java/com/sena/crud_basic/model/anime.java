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

    public void setAnime_id(int anime_id) {
        this.anime_id = anime_id;
    }

    public int getAnime_id() {
        return anime_id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setYear_premiere(Year year_premiere) {
        this.year_premiere = year_premiere;
    }

    public Year getYear_premiere() {
        return year_premiere;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setEstudio(estudio estudio) {
        this.estudio = estudio;
    }

    public estudio getEstudio() {
        return estudio;
    }
   
}
