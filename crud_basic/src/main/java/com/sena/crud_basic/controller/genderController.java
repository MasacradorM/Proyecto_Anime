package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.genderDTO;
import com.sena.crud_basic.service.genderService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/gender")
public class genderController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private genderService genderService;

    @PostMapping("/")
    public ResponseEntity<Object> registerGender(@RequestBody genderDTO gender) {
        genderService.save(gender);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }


}