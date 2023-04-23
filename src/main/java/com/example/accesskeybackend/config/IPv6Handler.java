package com.example.accesskeybackend.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IPv6Handler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> getExMessage(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
