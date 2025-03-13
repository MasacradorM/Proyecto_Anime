package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.characterDTO;
import com.sena.crud_basic.model.Character;
import com.sena.crud_basic.repository.Icharacter;

@Service
public class characterService {
        /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Icharacter data;

    // register and update
    public void save(characterDTO characterDTO) {
        Character characterRegister = convertToModel(characterDTO);
        data.save(characterRegister);
    }

    // se llaman desde el DTO
    public characterDTO convertToDTO(Character character) {
        characterDTO characterdto = new characterDTO(
            character.getName(),
            character.getDescription(),
            character.getImage(),
            character.getAnime()
);
        return characterdto;
    }

    // Se llama desde el model
    public Character convertToModel(characterDTO characterDTO) {
        Character character = new Character(
                0,
                characterDTO.getName(),
                characterDTO.getDescription(),
                characterDTO.getImage(),
                characterDTO.getAnime());
        return character;
    }

}
