package com.ead.authuser.config.security;

import com.ead.authuser.models.UserModel;
import com.ead.authuser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: "+username));

        return UserDetailsImpl.build(userModel);
    }


    public UserDetails loadUserByUserId(UUID userId) throws AuthenticationCredentialsNotFoundException {
        UserModel userModel = userRepository.findById(userId)
                .orElseThrow(() -> new AuthenticationCredentialsNotFoundException("User not found with id: "+userId));

        return UserDetailsImpl.build(userModel);
    }
}
