package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.animeDTO;
import com.sena.crud_basic.model.Anime;
import com.sena.crud_basic.repository.Ianime;


@Service
public class animeService {
    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Ianime data;

    // register and update
    public void save(animeDTO animeDTO) {
        Anime animeRegister = convertToModel(animeDTO);
        data.save(animeRegister);
    }

    // se llaman desde el DTO
    public animeDTO convertToDTO(Anime anime) {
        animeDTO animedto = new animeDTO(
            anime.getTitle(),
            anime.getSynopsis(),
            anime.getYear_premiere(),
            anime.getImage(),
            anime.getEstudio()
);
        return animedto;
    }

    // Se llama desde el model
    public Anime convertToModel(animeDTO animeDTO) {
        Anime anime = new Anime(
                0,
                animeDTO.getTitle(),
                animeDTO.getSynopsis(),
                animeDTO.getYear_premiere(),
                animeDTO.getImage(),
                animeDTO.getEstudio());
        return anime;
    }

}