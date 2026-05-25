package com.nothing.none.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new UsernameNotFoundException("User not found: " + username);
    }

    public boolean login(String username, String password) {
        // Implement login logic here
        return false;
    }

    public boolean register(String username, String password) {
        // Implement registration logic here
        return false;
    }
}
