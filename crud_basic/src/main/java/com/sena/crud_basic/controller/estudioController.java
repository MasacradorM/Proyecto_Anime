package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.estudioDTO;
import com.sena.crud_basic.service.estudioService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/estudio")
public class estudioController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private estudioService estudioService;

    @PostMapping("/")
    public ResponseEntity<Object> registerEstudio(@RequestBody estudioDTO estudio) {
        estudioService.save(estudio);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }


}