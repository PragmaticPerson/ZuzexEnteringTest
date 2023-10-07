package com.zuzex.service.services;

import com.zuzex.jpa.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService implements UserDetailsService {

    private UserJpaRepository repository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserJpaRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByName(username);
    }
}
