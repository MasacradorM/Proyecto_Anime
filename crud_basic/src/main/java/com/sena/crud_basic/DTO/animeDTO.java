package com.sena.crud_basic.DTO;

import java.time.Year;

import com.sena.crud_basic.model.Author;
import com.sena.crud_basic.model.Estudio;


public class animeDTO {
    private String title;
    private String synopsis;
    private Year year_premiere;
    private int episodes;
    private String image;
    private Estudio estudio;
    private Author author;

    public animeDTO( String title, String synopsis, Year year_premiere, int episodes, String image, Estudio estudio, Author author) {
        this.title = title;
        this.synopsis = synopsis;
        this.year_premiere = year_premiere;
        this.episodes = episodes;
        this.image = image;
        this.estudio = estudio;
        this.author = author;
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