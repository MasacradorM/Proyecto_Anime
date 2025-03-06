package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.countryDTO;
import com.sena.crud_basic.model.Country;
import com.sena.crud_basic.repository.Icountry;




@Service
public class countryService {

    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Icountry data;

    // register and update
    public void save(countryDTO countryDTO) {
        Country userRegister = converToModel(countryDTO);
        data.save(userRegister);
    }

    public countryDTO convertToDTO(Country country) {
        countryDTO countrydto = new countryDTO(
                country.getName());
        return countrydto;
    }

    public Country converToModel(countryDTO countryDTO) {
        Country country = new Country(
                0,
                countryDTO.getName());
        return country;
    }

}