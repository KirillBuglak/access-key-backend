package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.exception.NotValidURLException;
import com.example.accesskeybackend.template.service.IPv6Service;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class IPv6Controller {
    private final IPv6Service service;

    @GetMapping("/api/web/checkIpv6Support")
    public ResponseEntity<Boolean> checkIpv6Support(@RequestParam String siteUrl) throws NotValidURLException {
        return ResponseEntity.ok(service.checkURL(siteUrl).isSuccess());
    }

    @ExceptionHandler(NotValidURLException.class)
    public ResponseEntity<String> handleException(NotValidURLException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
