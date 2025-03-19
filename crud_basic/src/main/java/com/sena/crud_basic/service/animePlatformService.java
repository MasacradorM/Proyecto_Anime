package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.animePlatformDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.AnimePlatform;
import com.sena.crud_basic.repository.IanimePlatform;



@Service
public class animePlatformService {
        /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private IanimePlatform data;
    public List<AnimePlatform> findAll() {

        return data.findAll();

    }

    public Optional<AnimePlatform> findById(int animeplatform_id) {
        return data.findById(animeplatform_id);
    }

    public responseDTO deleteAnimePlatform(int animeplatform_id) {
        if (!findById(animeplatform_id).isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.OK.toString(),
                    "The register does not exist");
            return respuesta;
        }
        data.deleteById(animeplatform_id);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se eliminó correctamente");
        return respuesta;
    }
    // register and update
    public void save(animePlatformDTO animePlatformDTO) {
        AnimePlatform animePlatformRegister = convertToModel(animePlatformDTO);
        data.save(animePlatformRegister);
    }

    // se llaman desde el DTO
    public animePlatformDTO convertToDTO(AnimePlatform animePlatform) {
        animePlatformDTO animePlatformdto = new animePlatformDTO(
            animePlatform.getAnime(),
            animePlatform.getPlatform());
        return animePlatformdto;
    }

    // Se llama desde el model
    public AnimePlatform convertToModel(animePlatformDTO animePlatformDTO) {
        AnimePlatform animePlatform = new AnimePlatform(
                0,
                animePlatformDTO.getAnime(),
                animePlatformDTO.getPlatform());
        return animePlatform;
    }

}
