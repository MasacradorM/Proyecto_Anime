package com.sena.crud_basic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="estudio")
public class estudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="estudio_id")
    private int estudio_id;

    @Column(name="name", length = 50, nullable = false)
    private String name;

    @Column(name="image", length = 150, nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private country country;

    public void setEstudio_id(int estudio_id) {
        this.estudio_id = estudio_id;
    }

    public int getEstudio_id() {
        return estudio_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setCountry(country country) {
        this.country = country;
    }

    public country getCountry() {
        return country;
    }

}
