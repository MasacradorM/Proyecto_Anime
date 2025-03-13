package com.sena.crud_basic.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.animePlatformDTO;
import com.sena.crud_basic.service.animePlatformService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


}