package dev.ungu.mechanicshop.service;

import dev.ungu.mechanicshop.dto.SignUpRequest;
import dev.ungu.mechanicshop.model.User;

public interface AuthenticationService {
    User signUp(SignUpRequest signUpRequest);
}
