package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.estudioDTO;
import com.sena.crud_basic.DTO.responseDTO;
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

     public List<Estudio> findAll() {

        return data.findAll();

    }

    public Optional<Estudio> findById(int estudio_id) {
        return data.findById(estudio_id);
    }

    public responseDTO deleteEstudio(int estudio_id) {
        if (!findById(estudio_id).isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.OK.toString(),
                    "The register does not exist");
            return respuesta;
        }
        data.deleteById(estudio_id);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se eliminó correctamente");
        return respuesta;
    }
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