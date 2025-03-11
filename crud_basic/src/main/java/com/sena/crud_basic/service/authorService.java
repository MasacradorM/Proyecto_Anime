package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.authorDTO;
import com.sena.crud_basic.model.Author;
import com.sena.crud_basic.repository.Iauthor;


@Service
public class authorService {
    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Iauthor data;

    // register and update
    public void save(authorDTO authorDTO) {
        Author authorRegister = convertToModel(authorDTO);
        data.save(authorRegister);
    }

    // se llaman desde el DTO
    public authorDTO convertToDTO(Author author) {
        authorDTO authordto = new authorDTO(
            author.getImage(),
            author.getCountry(),
            author.getName());
        return authordto;
    }

    // Se llama desde el model
    public Author convertToModel(authorDTO authorDTO) {
        Author author = new Author(
                0,
                authorDTO.getName(),
                authorDTO.getImage(),
                authorDTO.getCountry_id());
        return author;
    }

}