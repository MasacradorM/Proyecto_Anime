package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.seasonDTO;
import com.sena.crud_basic.service.seasonService;

@RestController
@RequestMapping("/api/v1/season")

public class seasonController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private seasonService seasonService;

    @PostMapping("/")
    public ResponseEntity<Object> registerSeason(@RequestBody seasonDTO season) {
        seasonService.save(season);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }

}
