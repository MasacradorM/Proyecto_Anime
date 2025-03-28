package com.sena.crud_basic.DTO;

import java.time.LocalDate;

import com.sena.crud_basic.model.Anime;


public class seasonDTO {
    private String name;
    private LocalDate release_date;
    private Anime anime;

    public seasonDTO(String name, LocalDate release_date, Anime anime) {
        this.name = name;
        this.release_date = release_date;
        this.anime = anime;
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

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public Anime getAnime() {
        return anime;
    }   

}
