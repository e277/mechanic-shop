package dev.ungu.mechanicshop.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.ungu.mechanicshop.dto.SignUpRequest;
import dev.ungu.mechanicshop.model.Role;
import dev.ungu.mechanicshop.model.User;
import dev.ungu.mechanicshop.repository.UserRepository;
import dev.ungu.mechanicshop.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public User signUp(SignUpRequest signUpRequest) {
        
        User user = new User();
        
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setEmail(signUpRequest.getEmail());
        user.setRole(Role.USER);

        return userRepository.save(user);
    }
}
