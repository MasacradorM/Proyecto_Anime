package com.sena.crud_basic.DTO;

import com.sena.crud_basic.model.Country;

public class platformDTO {

    private String name;
    private Country country_id;
    private String image;

    

    public platformDTO(String name, Country country_id, String image) {
        this.name = name;
        this.country_id = country_id;
        this.image = image;

    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    
    public Country getCountry_id(){
        return country_id;
    }

    public void setCountry_id(Country country_id) {
        this.country_id = country_id;   
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
}