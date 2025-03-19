package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.characterDTO;
import com.sena.crud_basic.service.characterService;

@RestController
@RequestMapping("/api/v1/character")

public class characterController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private characterService characterService;

    @PostMapping("/")
    public ResponseEntity<Object> registerCharacter(@RequestBody characterDTO character) {
        characterService.save(character);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAllcharacter() {
        var listcharacter = characterService.findAll();
        // List<character> listcharacter2= characterService.findAll();
        return new ResponseEntity<>(listcharacter, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnecharacter(@PathVariable int character_id) {
        var character = characterService.findById(character_id);
        if (!character.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(character, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCharacter(@PathVariable int character_id) {
        var message= characterService.deleteCharacter(character_id);
        
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
