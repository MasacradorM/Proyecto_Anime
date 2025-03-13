package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.animePlatformDTO;
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
