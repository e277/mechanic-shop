package dev.ungu.mechanicshop.service;

import dev.ungu.mechanicshop.dto.JwtAuthenticationResponse;
import dev.ungu.mechanicshop.dto.RefreshTokenRequest;
import dev.ungu.mechanicshop.dto.SignInRequest;
import dev.ungu.mechanicshop.dto.SignUpRequest;
import dev.ungu.mechanicshop.model.User;

public interface AuthenticationService {
    User signUp(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signIn(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
