package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.estudioDTO;
import com.sena.crud_basic.model.Estudio;
import com.sena.crud_basic.repository.Iestudio;


@Service
public class estudioService {
    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Iestudio data;

    // register and update
    public void save(estudioDTO estudioDTO) {
        Estudio estudioRegister = convertToModel(estudioDTO);
        data.save(estudioRegister);
    }

    // se llaman desde el DTO
    public estudioDTO convertToDTO(Estudio estudio) {
        estudioDTO estudiodto = new estudioDTO(
            estudio.getImage(),
            estudio.getCountry(),
            estudio.getName());
        return estudiodto;
    }

    // Se llama desde el model
    public Estudio convertToModel(estudioDTO estudioDTO) {
        Estudio estudio = new Estudio(
                0,
                estudioDTO.getName(),
                estudioDTO.getImage(),
                estudioDTO.getCountry_id());
        return estudio;
    }

}