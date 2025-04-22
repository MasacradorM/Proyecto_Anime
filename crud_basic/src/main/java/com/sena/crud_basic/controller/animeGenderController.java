package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.animeGenderDTO;
import com.sena.crud_basic.service.animeGenderService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/animeGender")
public class animeGenderController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private animeGenderService animeGenderService;

    @PostMapping("/")
    public ResponseEntity<Object> registerAnimeGender(@RequestBody animeGenderDTO animeGender) {
        animeGenderService.save(animeGender);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAllanimeGender() {
        var listanimeGender = animeGenderService.findAll();
        // List<animeGender> listanimeGender2= animeGenderService.findAll();
        return new ResponseEntity<>(listanimeGender, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneanimeGender(@PathVariable int animeGender_id) {
        var animeGender = animeGenderService.findById(animeGender_id);
        if (!animeGender.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(animeGender, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteanimeGender(@PathVariable int animeGender_id) {
        var message= animeGenderService.deleteAnimeGender(animeGender_id);
        
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}