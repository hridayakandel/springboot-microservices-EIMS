package com.hridayakandel.com.springbootdockerteaching.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class dockerController {
    @GetMapping("/docker")
    public ResponseEntity<String> getDockerInfoApi(){
        return new ResponseEntity<>("Hello from Docker!", HttpStatus.OK);
    }
}
