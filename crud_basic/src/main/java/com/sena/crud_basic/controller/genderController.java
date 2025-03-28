package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.genderDTO;
import com.sena.crud_basic.service.genderService;



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
    @GetMapping("/")
    public ResponseEntity<Object> getAllgender() {
        var listgender = genderService.findAll();
        // List<gender> listgender2= genderService.findAll();
        return new ResponseEntity<>(listgender, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneGender(@PathVariable int gender_id) {
        var gender = genderService.findById(gender_id);
        if (!gender.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(gender, HttpStatus.OK);
    }

    @GetMapping("/filter/{filter}")
    public ResponseEntity<Object> getListGenderForName(@PathVariable String filter) {
        var genderList = genderService.getListGenderForName(filter);
        return new ResponseEntity<>(genderList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGender(@PathVariable int gender_id) {
        var message= genderService.deleteGender(gender_id);
        
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}