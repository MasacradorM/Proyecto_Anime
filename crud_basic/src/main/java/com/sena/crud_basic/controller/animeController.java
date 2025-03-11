package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.animeDTO;
import com.sena.crud_basic.service.animeService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


}