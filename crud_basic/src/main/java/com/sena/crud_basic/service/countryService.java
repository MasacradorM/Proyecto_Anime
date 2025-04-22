package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.countryDTO;
import com.sena.crud_basic.DTO.responseDTO;
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

    public List<Country> findAll() {

        return data.findAll();

    }

    public Optional<Country> findById(int countr_id) {
        return data.findById(countr_id);
    }

    public responseDTO deleteCountry(int countr_id) {
        if (!findById(countr_id).isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.OK.toString(),
                    "The register does not exist");
            return respuesta;
        }
        data.deleteById(countr_id);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se eliminó correctamente");
        return respuesta;
    }
    // register and update
    public void save(countryDTO countryDTO) {
        Country countryRegister = convertToModel(countryDTO);
        data.save(countryRegister);
    }

    public countryDTO convertToDTO(Country country) {
        countryDTO countrydto = new countryDTO(
                country.getName());
        return countrydto;
    }

    public Country convertToModel(countryDTO countryDTO) {
        Country country = new Country(
                0,
                countryDTO.getName());
        return country;
    }

}