package com.sena.crud_basic.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="anime_platform")
public class AnimePlatform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="anime_platform_id;")
    private int anime_platform_id;
    
    @ManyToOne
    @JoinColumn(name="anime_id", nullable = false)
    private Anime anime;

    @ManyToOne
    @JoinColumn(name="platform_id", nullable = false)
    private Platform platform;

    public AnimePlatform(){}
    public AnimePlatform( int anime_platform_id,Anime anime, Platform platform) {
        this.anime_platform_id = anime_platform_id;
        this.anime = anime;
        this.platform = platform;
    }

    public void setAnime_platform_id(int anime_platform_id) {
        this.anime_platform_id = anime_platform_id;
    }

    public int getAnime_platform_id() {
        return anime_platform_id;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }
    

    public Anime getAnime() {
        return anime;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Platform getPlatform() {
        return platform;
    }

}
