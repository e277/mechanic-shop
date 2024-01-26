package dev.ungu.mechanicshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.ungu.mechanicshop.dto.JwtAuthenticationResponse;
import dev.ungu.mechanicshop.dto.RefreshTokenRequest;
import dev.ungu.mechanicshop.dto.SignUpRequest;
import dev.ungu.mechanicshop.dto.UserResponseDTO;
import dev.ungu.mechanicshop.dto.SignInRequest;
import dev.ungu.mechanicshop.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<UserResponseDTO> signUp(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/signin")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }

    @PostMapping("/refresh")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<JwtAuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }
    
}
