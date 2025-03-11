package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.genderDTO;
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
                genderDTO.getName());
        return gender;
    }

}