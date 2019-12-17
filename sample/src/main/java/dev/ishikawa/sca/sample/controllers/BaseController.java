package dev.ishikawa.sca.sample.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class BaseController {
    protected ResponseEntity<String> buildResponse(Object response) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(String.format("%s", response));
    }
}

