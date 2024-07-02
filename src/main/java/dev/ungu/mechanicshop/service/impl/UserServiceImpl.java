package dev.ungu.mechanicshop.service.impl;

import dev.ungu.mechanicshop.repository.UserRepository;
import dev.ungu.mechanicshop.service.UserService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDatailsService() {
        return new UserDetailsService() {
            // @Override
            // public UserDetails loadUserByUsername(String username) {
            //     return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            // }
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByUsername(username).orElseThrow(null);
            }
        };
    }
    
}
