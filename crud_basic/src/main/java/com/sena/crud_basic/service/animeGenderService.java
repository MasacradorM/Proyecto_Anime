package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.animeGenderDTO;
import com.sena.crud_basic.model.AnimeGender;
import com.sena.crud_basic.repository.IanimeGender;

@Service
public class animeGenderService {
        /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private IanimeGender data;

    // register and update
    public void save(animeGenderDTO animeGenderDTO) {
        AnimeGender animeGenderRegister = convertToModel(animeGenderDTO);
        data.save(animeGenderRegister);
    }

    // se llaman desde el DTO
    public animeGenderDTO convertToDTO(AnimeGender animeGender) {
        animeGenderDTO animeGenderdto = new animeGenderDTO(
            animeGender.getGender(),
            animeGender.getAnime());
        return animeGenderdto;
    }

    // Se llama desde el model
    public AnimeGender convertToModel(animeGenderDTO animeGenderDTO) {
        AnimeGender animeGender = new AnimeGender(
                0,
                animeGenderDTO.getGender(),
                animeGenderDTO.getAnime());
        return animeGender;
    }

}
