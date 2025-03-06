package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.countryDTO;
import com.sena.crud_basic.service.countryService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/user")
public class countryController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private countryService countryService;

    @PostMapping("/")
    public ResponseEntity<Object> registerUser(@RequestBody countryDTO country) {
        countryService.save(country);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }

}