package com.sena.crud_basic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="anime_platform")
public class AnimePlatform {

    @ManyToOne
    @JoinColumn(name="anime_id", nullable = false)
    private Anime anime;

    @ManyToOne
    @JoinColumn(name="platform_id", nullable = false)
    private Platform platform;


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
