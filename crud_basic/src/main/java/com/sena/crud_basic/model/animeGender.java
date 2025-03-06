package com.sena.crud_basic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="anime_gender")
public class animeGender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="anime_gender_id")
    private int anime_gender_id;

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private gender gender;

    @ManyToOne
    @JoinColumn(name = "anime_id", nullable = false)
    private anime anime;

    public void setAnime_gender_id(int anime_gender_id) {
        this.anime_gender_id = anime_gender_id;
    }

    public int getAnime_gender_id() {
        return anime_gender_id;
    }

    public void setGender(gender gender) {
        this.gender = gender;
    }

    public gender getGender() {
        return gender;
    }

    public void setAnime(anime anime) {
        this.anime = anime;
    }

    public anime getAnime() {
        return anime;
    }
    
}
