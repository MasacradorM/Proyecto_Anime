package com.sena.crud_basic.model;

import 

public class trajhDTO {
    private int estudio_id;

    private String name;

    private String image;


    private Country country;

    public Estudio(int estudio_id, String name, String image, Country country) {
        this.estudio_id = estudio_id;
        this.name = name;
        this.image = image;
        this.country = country;
    }

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

    public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

}
