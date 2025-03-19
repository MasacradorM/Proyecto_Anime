package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.platformDTO;
import com.sena.crud_basic.service.platformService;



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
@RequestMapping("/api/v1/platform")
public class platformController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private platformService platformService;

    @PostMapping("/")
    public ResponseEntity<Object> registerPlatform(@RequestBody platformDTO platform) {
        platformService.save(platform);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAllplatform() {
        var listplatform = platformService.findAll();
        // List<platform> listplatform2= platformService.findAll();
        return new ResponseEntity<>(listplatform, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneplatform(@PathVariable int platform_id) {
        var platform = platformService.findById(platform_id);
        if (!platform.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(platform, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteplatform(@PathVariable int platform_id) {
        var message= platformService.deletePlatform(platform_id);
        
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}