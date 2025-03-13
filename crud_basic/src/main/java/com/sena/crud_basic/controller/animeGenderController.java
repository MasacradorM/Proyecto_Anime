package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.animeGenderDTO;
import com.sena.crud_basic.service.animeGenderService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


}