package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.animeDTO;
import com.sena.crud_basic.DTO.responseDTO;
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
    public List<Anime> findAll() {

        return data.findAll();

    }

    public Optional<Anime> findById(int anime_id) {
        return data.findById(anime_id);
    }

    public responseDTO deleteAnime(int anime_id) {
        if (!findById(anime_id).isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.OK.toString(),
                    "The register does not exist");
            return respuesta;
        }
        data.deleteById(anime_id);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se eliminó correctamente");
        return respuesta;
    }
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
            anime.getEpisodes(),
            anime.getImage(),
            anime.getEstudio(),
            anime.getAuthor());
        return animedto;
    }

    // Se llama desde el model
    public Anime convertToModel(animeDTO animeDTO) {
        Anime anime = new Anime(
                0,
                animeDTO.getTitle(),
                animeDTO.getSynopsis(),
                animeDTO.getYear_premiere(),
                animeDTO.getEpisodes(),
                animeDTO.getImage(),
                animeDTO.getEstudio(),
                animeDTO.getAuthor());
        return anime;
    }

}