package com.sena.crud_basic.DTO;

import com.sena.crud_basic.model.Anime;
import com.sena.crud_basic.model.Gender;



public class animeGenderDTO {
    private Gender gender;
    private Anime anime;

    public animeGenderDTO(Gender gender, Anime anime) {
        this.gender = gender;
        this.anime = anime;
    }

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
