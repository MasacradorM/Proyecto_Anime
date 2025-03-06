package com.sena.crud_basic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="anime_platform")
public class animePlatform {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="anime_platform_id")
    private int anime_platform_id;

    @ManyToOne
    @JoinColumn(name="anime_id", nullable = false)
    private anime anime;

    @ManyToOne
    @JoinColumn(name="platform_id", nullable = false)
    private platform platform;

    public void setAnime_platform_id(int anime_platform_id) {
        this.anime_platform_id = anime_platform_id;
    }

    public int getAnime_platform_id() {
        return anime_platform_id;
    }

    public void setAnime(anime anime) {
        this.anime = anime;
    }
    

    public anime getAnime() {
        return anime;
    }

}
