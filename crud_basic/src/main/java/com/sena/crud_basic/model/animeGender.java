package com.sena.crud_basic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="anime_gender")
public class AnimeGender {

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "anime_id", nullable = false)
    private Anime anime;


    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public Anime getAnime() {
        return anime;
    }
    
}
