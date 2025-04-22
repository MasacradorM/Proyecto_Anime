package com.sena.crud_basic.model;
import jakarta.persistence.Entity;

import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
@Entity(name="anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="anime_id")
    private int anime_id;

    @Column(name="title", length = 50, nullable = false)
    private String title;

    @Lob
    @Column(name="synopsis", columnDefinition = "TEXT", nullable = false)
    private String synopsis;

    @Column(name="year_premiere", length = 4, nullable = false)
    private Year year_premiere;

    @Column(name="episode", length = 50, nullable = false)
    private int episodes;

    @Lob
    @Column(name="image", columnDefinition = "TEXT", nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "estudio_id", nullable = false)
    private Estudio estudio;


    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Anime(){}

    public Anime(int anime_id, String title, String synopsis, Year year_premiere, int episodes, String image, Estudio estudio, Author author) {
        this.anime_id = anime_id;
        this.title = title;
        this.synopsis = synopsis;
        this.year_premiere = year_premiere;
        this.episodes = episodes;
        this.image = image;
        this.estudio = estudio;
        this.author = author;
    }

    public void setAnime_id(int anime_id) {
        this.anime_id = anime_id;
    }

    public int getAnime_id() {
        return anime_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public Author getAuthor() {
        return author;
    }


   
}
