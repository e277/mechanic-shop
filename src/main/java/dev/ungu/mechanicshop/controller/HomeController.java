package dev.ungu.mechanicshop.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public ResponseEntity<String> home (Principal principal) {
        return ResponseEntity.ok("Hello, " + principal.getName() + "!");
    }
}
