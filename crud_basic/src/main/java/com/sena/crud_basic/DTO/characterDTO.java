package com.sena.crud_basic.DTO;

import com.sena.crud_basic.model.Anime;


public class characterDTO {
    private String name;
    private String description;
    private String image;
    private Anime anime;

    public characterDTO( String name, String description, String image, Anime anime) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.anime = anime;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public Anime getAnime() {
        return anime;
    }
    
}
