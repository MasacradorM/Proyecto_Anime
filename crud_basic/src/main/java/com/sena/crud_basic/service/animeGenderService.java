package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.animeGenderDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.AnimeGender;
import com.sena.crud_basic.repository.IanimeGender;

@Service
public class animeGenderService {

    @Autowired
    private IanimeGender data;
    public List<AnimeGender> findAll() {

        return data.findAll();

    }

    public Optional<AnimeGender> findById(int animeGender_id) {
        return data.findById(animeGender_id);
    }

    public responseDTO deleteAnimeGender(int animeGender_id) {
        if (!findById(animeGender_id).isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.OK.toString(),
                    "The register does not exist");
            return respuesta;
        }
        data.deleteById(animeGender_id);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se eliminó correctamente");
        return respuesta;
    }
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
