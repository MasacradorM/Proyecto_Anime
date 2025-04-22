package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.animeDTO;
import com.sena.crud_basic.service.animeService;



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
@RequestMapping("/api/v1/anime")
public class animeController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private animeService animeService;

    @PostMapping("/")
    public ResponseEntity<Object> registerAnime(@RequestBody animeDTO anime) {
        animeService.save(anime);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAllanime() {
        var listanime = animeService.findAll();
        // List<anime> listanime2= animeService.findAll();
        return new ResponseEntity<>(listanime, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneanime(@PathVariable int anime_id) {
        var anime = animeService.findById(anime_id);
        if (!anime.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(anime, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAnime(@PathVariable int anime_id) {
        var message= animeService.deleteAnime(anime_id);
        
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}