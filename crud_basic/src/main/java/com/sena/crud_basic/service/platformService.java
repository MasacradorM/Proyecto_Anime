package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.platformDTO;
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