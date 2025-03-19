package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.animePlatformDTO;
import com.sena.crud_basic.service.animePlatformService;



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
@RequestMapping("/api/v1/animePlatform")
public class animePlatformController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private animePlatformService animePlatformService;

    @PostMapping("/")
    public ResponseEntity<Object> registerAnimePlatform(@RequestBody animePlatformDTO animePlatform) {
        animePlatformService.save(animePlatform);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAllanimePlatform() {
        var listanimePlatform = animePlatformService.findAll();
        // List<animePlatform> listanimePlatform2= animePlatformService.findAll();
        return new ResponseEntity<>(listanimePlatform, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneanimePlatform(@PathVariable int animePlatform_id) {
        var animePlatform = animePlatformService.findById(animePlatform_id);
        if (!animePlatform.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(animePlatform, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteanimePlatform(@PathVariable int animePlatform_id) {
        var message= animePlatformService.deleteAnimePlatform(animePlatform_id);
        
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}