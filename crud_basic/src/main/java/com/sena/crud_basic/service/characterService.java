package com.sena.crud_basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.characterDTO;
import com.sena.crud_basic.DTO.responseDTO;
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
    public List<Character> findAll() {

        return data.findAll();

    }

    public Optional<Character> findById(int character_id) {
        return data.findById(character_id);
    }

    public responseDTO deleteCharacter(int character_id) {
        if (!findById(character_id).isPresent()) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.OK.toString(),
                    "The register does not exist");
            return respuesta;
        }
        data.deleteById(character_id);
        responseDTO respuesta = new responseDTO(
                HttpStatus.OK.toString(),
                "Se eliminó correctamente");
        return respuesta;
    }
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
