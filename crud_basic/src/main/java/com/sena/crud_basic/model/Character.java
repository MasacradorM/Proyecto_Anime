package com.sena.crud_basic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity(name="characters")
public class Character {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="character_id")
    private int character_id;

    @Column(name="name", length = 30, nullable = false)
    private String name;

    @Lob
    @Column(name="description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Lob
    @Column(name="image", columnDefinition = "TEXT", nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "anime_id", nullable = false)
    private Anime anime;

    public Character(){}
    public Character(int character_id, String name, String description, String image, Anime anime) {
        this.character_id = character_id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.anime = anime;
    }

    public void setCharacter_id(int character_id) {
        this.character_id = character_id;
    }

    public int getCharacter_id() {
        return character_id;
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

