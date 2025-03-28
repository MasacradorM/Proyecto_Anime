package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.platformDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.Platform;
import com.sena.crud_basic.repository.Iplatform;


@Service
public class platformService {
    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Iplatform data;
    public List<Platform> findAll() {

        return data.findAll();

    }

    public Optional<Platform> findById(int platform_id) {
        return data.findById(platform_id);
    }

    public responseDTO deletePlatform(int platform_id) {
        if (!findById(platform_id).isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.OK.toString(),
                    "The register does not exist");
            return respuesta;
        }
        data.deleteById(platform_id);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se eliminó correctamente");
        return respuesta;
    }
    // register and update
    public void save(platformDTO platformDTO) {
        Platform platformRegister = convertToModel(platformDTO);
        data.save(platformRegister);
    }

    // se llaman desde el DTO
    public platformDTO convertToDTO(Platform platform) {
        platformDTO platformdto = new platformDTO(
            platform.getName(),
            platform.getCountry(),
            platform.getImage());
        return platformdto;
    }

    // Se llama desde el model
    public Platform convertToModel(platformDTO platformDTO) {
        Platform platform = new Platform(
                0,
                platformDTO.getName(),
                platformDTO.getImage(),
                platformDTO.getCountry_id());
        return platform;
    }

}