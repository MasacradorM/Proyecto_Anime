package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.platformDTO;
import com.sena.crud_basic.service.platformService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


}