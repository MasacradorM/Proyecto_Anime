package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.authorDTO;
import com.sena.crud_basic.service.authorService;



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
    @GetMapping("/")
    public ResponseEntity<Object> getAllauthor() {
        var listauthor = authorService.findAll();
        // List<author> listauthor2= authorService.findAll();
        return new ResponseEntity<>(listauthor, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneauthor(@PathVariable int author_id) {
        var author = authorService.findById(author_id);
        if (!author.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable int author_id) {
        var message= authorService.deleteAuthor(author_id);
        
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
