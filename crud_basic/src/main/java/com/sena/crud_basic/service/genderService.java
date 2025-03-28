package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.genderDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.Gender;
import com.sena.crud_basic.repository.Igender;


@Service
public class genderService {
    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Igender data;

    public List<Gender> findAll() {
        return data.findAll();
    }

    public List<Gender> getListGenderForName(String filter) {
        return data.getListGenderForName(filter);
    }

    public Optional<Gender> findById(int gender_id) {
        return data.findById(gender_id);
    }

    public responseDTO deleteGender(int gender_id) {
        if (!findById(gender_id).isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.OK.toString(),
                    "The register does not exist");
            return respuesta;
        }
        data.deleteById(gender_id);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se eliminó correctamente");
        return respuesta;
    }
    // register and update
    public void save(genderDTO cgenderDTO) {
        Gender cgenderRegister = convertToModel(cgenderDTO);
        data.save(cgenderRegister);
    }

    public genderDTO convertToDTO(Gender cgender) {
        genderDTO cgenderdto = new genderDTO(
                cgender.getName());
        return cgenderdto;
    }

    public Gender convertToModel(genderDTO genderDTO) {
        Gender gender = new Gender(
                0,
                genderDTO.getName(),
                true);
        return gender;
    }

}