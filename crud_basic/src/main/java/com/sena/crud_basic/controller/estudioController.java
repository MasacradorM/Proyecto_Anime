package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.estudioDTO;
import com.sena.crud_basic.service.estudioService;



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
    @GetMapping("/")
    public ResponseEntity<Object> getAllestudio() {
        var listestudio = estudioService.findAll();
        // List<estudio> listestudio2= estudioService.findAll();
        return new ResponseEntity<>(listestudio, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneestudio(@PathVariable int estudio_id) {
        var estudio = estudioService.findById(estudio_id);
        if (!estudio.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(estudio, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEstudio(@PathVariable int estudio_id) {
        var message= estudioService.deleteEstudio(estudio_id);
        
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


}