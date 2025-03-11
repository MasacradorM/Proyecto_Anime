package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.authorDTO;
import com.sena.crud_basic.service.authorService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/author")
public class authorController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private authorService authorService;

    @PostMapping("/")
    public ResponseEntity<Object> registerAuthor(@RequestBody authorDTO author) {
        authorService.save(author);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }


}
