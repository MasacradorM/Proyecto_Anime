package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.seasonDTO;
import com.sena.crud_basic.model.Season;
import com.sena.crud_basic.repository.Iseason;

@Service
public class seasonService {
        /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Iseason data;

    // register and update
    public void save(seasonDTO seasonDTO) {
        Season seasonRegister = convertToModel(seasonDTO);
        data.save(seasonRegister);
    }

    // se llaman desde el DTO
    public seasonDTO convertToDTO(Season season) {
        seasonDTO seasondto = new seasonDTO(
            season.getName(),
            season.getRelease_date(),
            season.getAnime());
        return seasondto;
    }

    // Se llama desde el model
    public Season convertToModel(seasonDTO seasonDTO) {
        Season season = new Season(
                0,
                seasonDTO.getName(),
                seasonDTO.getRelease_date(),
                seasonDTO.getAnime());
        return season;
    }

}